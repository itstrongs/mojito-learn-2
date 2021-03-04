package com.mojito.learn.demo.redis;//package com.charles.learn.redis;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-04-20 12:17
// */
//public class RedisTest {
//
//    /** 库存 */
//    private static Integer inventory = 1001;
//    private static final int NUM = 1000;
//    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
//    /** 线程锁 */
//    private static ReentrantLock reentrantLock = new ReentrantLock();
//
//    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory,
//                inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue);
//        //CountDownLatch：使一个线程等待其他线程各自执行完毕后再执行
//        CountDownLatch countDownLatch = new CountDownLatch(NUM);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < NUM; i++) {
//            threadPoolExecutor.execute(() -> {
//                reentrantLock.lock();
//                inventory--;
//                reentrantLock.unlock();
//                System.out.println("线程执行：" + Thread.currentThread().getName());
//                //将count值减1
//                countDownLatch.countDown();
//            });
//        }
//        threadPoolExecutor.shutdown();
//        try {
//            //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("执行线程数：" + NUM + "，总耗时：" + (end - start) + "，库存数：" + inventory);
//    }
//}
