package com.mojito.learn.knowledge;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁演示
 * <p>
 * 可重入，就是可以重复获取相同的锁，重入降低了编程复杂性
 *
 * @author liufengqiang
 * @date 2021-05-18 15:18:38
 */
class ReentrantLockTest {

    /**
     * synchronized 是可重入锁
     */
    @Test
    void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * ReentrantLock 也是可重入锁
     */
    @Test
    void test2() {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("第1次获取锁，这个锁是：" + lock);

                int index = 1;
                while (true) {
                    try {
                        lock.lock();
                        System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);

                        try {
                            Thread.sleep(new Random().nextInt(200));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (index == 10) {
                            break;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
