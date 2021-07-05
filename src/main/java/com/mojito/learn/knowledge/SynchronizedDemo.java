package com.mojito.learn.knowledge;

/**
 * @author liufengqiang
 * @date 2021-06-08 13:39:35
 */
public class SynchronizedDemo {

    private static SynchronizedDemo sychronizedTest = new SynchronizedDemo();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("主线程开始");
        Thread thread1 = new Thread(new thred1());
        Thread thread2 = new Thread(new thred2());
        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程一共花费时间：" + (System.currentTimeMillis() - startTime));
    }

    public static class thred1 implements Runnable {
        @Override
        public void run() {
            method1();
        }
    }

    public static class thred2 implements Runnable {
        @Override
        public void run() {
            sychronizedTest.method2();
        }
    }

    /**
     * 静态方法加锁
     */
    public static synchronized void method1() {
        long start = System.currentTimeMillis();
        System.out.println("方法1开始执行");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法1执行结束花费时间：" + (System.currentTimeMillis() - start));
    }

    public synchronized void method2() {
        synchronized (this) {

        }
        long start = System.currentTimeMillis();
        System.out.println("方法2开始执行");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法2执行结束花费时间：" + (System.currentTimeMillis() - start));
    }
}
