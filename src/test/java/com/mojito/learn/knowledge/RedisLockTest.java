package com.mojito.learn.knowledge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * redis 实现分布式锁
 *
 * @author liufengqiang
 * @date 2021-05-18 16:17:59
 */
class RedisLockTest {

    private static Integer inventory = 11;
    private static Integer NUM = 10;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Jedis jedis;
    private SetParams params;
    private static final String LOCK_KEY = "redis_lock";
    private RLock lock;

    @BeforeEach
    void init() {
        jedis = new Jedis("192.168.137.151", 6379);
        jedis.auth("nRDPkyJWKgRNo1j4M48=");
        params = SetParams.setParams().nx().px(3);

        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.137.151:6379").setPassword("nRDPkyJWKgRNo1j4M48=");
        RedissonClient client = Redisson.create(config);
        lock = client.getLock("lock1");
    }

    /**
     * 加分布式锁
     */
    @Test
    void test4() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                lock.lock();
                inventory--;
                System.out.println("线程执行：" + Thread.currentThread().getName());
                lock.unlock();
            });
        }
        threadPoolExecutor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + "，总耗时：" + (end - start) + "，库存数为：" + inventory);
    }

    /**
     * 加分布式锁
     */
    @Test
    void test3() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                lock(UUID.randomUUID().toString());
                inventory--;
                System.out.println("线程执行：" + Thread.currentThread().getName());
                unlock(UUID.randomUUID().toString());
            });
        }
        threadPoolExecutor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + "，总耗时：" + (end - start) + "，库存数为：" + inventory);
    }

    public boolean lock(String value) {
        Long start = System.currentTimeMillis();
        try {
            for (; ; ) {
                String redisLock = jedis.set(LOCK_KEY, value, params);
                if ("OK".equals(redisLock)) {
                    return true;
                }

                // 否则循环等待，在timeout时间内仍未获取到锁，则获取失败          
                long l = System.currentTimeMillis() - start;
                if (l >= 1000) {
                    return false;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            jedis.close();
        }
    }

    public boolean unlock(String id) {
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then" + "   return redis.call('del',KEYS[1]) " + "else" + "   return 0 " + "end";

        try {
            String result = jedis.eval(script, Collections.singletonList(LOCK_KEY), Collections.singletonList(id)).toString();
            return "1".equals(result) ? true : false;
        } finally {
            jedis.close();
        }
    }

    /**
     * 不加锁异常情况
     */
    @Test
    void test1() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                inventory--;
                System.out.println("线程执行：" + Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }
        threadPoolExecutor.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + "，总耗时：" + (end - start) + "，库存数为：" + inventory);
    }

    /**
     * 加本地锁正常情况
     */
    @Test
    void test2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                reentrantLock.lock();
                inventory--;
                reentrantLock.unlock();
                System.out.println("线程执行：" + Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }
        threadPoolExecutor.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + "，总耗时：" + (end - start) + "，库存数为：" + inventory);
    }
}
