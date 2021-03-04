package com.mojito.learn.test;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description 线程相关demo
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-06-03 17:13
 */
public class ThreadDemo {

    private static ThreadPoolExecutor executor;
    private static ReentrantLock lock = new ReentrantLock();
    private static Integer num = 1000;

    public static void main(String[] args) throws IOException {
        int index = 2;
        switch (index) {
            case 0:
                // 自定义线程池
                int corePoolSize = 5;
                int maximumPoolSize = 10;
                long keepAliveTime = 10;
                TimeUnit unit = TimeUnit.SECONDS;
                BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
                ThreadFactory threadFactory = new NameTreadFactory();
                RejectedExecutionHandler handler = new MyIgnorePolicy();
                executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
                executor.prestartAllCoreThreads(); // 预启动所有核心线程
                break;
            case 1:
                // 线程池执行流程
                initiatorProcedure();

                // ReentrantLock 实现同步
                reentrantLock();
                break;
            case 2:
                VolatileThread thread = new VolatileThread();
                thread.start();
                for(;;) {
//                    synchronized (thread) {
                        if (thread.isFlag()) {
                            System.out.println("哈哈");
                        }
//                    }
                }
            default:
        }
    }

    static class VolatileThread extends Thread {

        private volatile boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag=" + flag);
        }
    }

    private static void reentrantLock() {
        for (int i = 0; i < 30; i++) {
            executor.execute(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("库存：" + num--);
                    }
                } finally {
                    lock.unlock();
                }
            });
        }
    }

    /**
     * 线程池流程：首先判断corePoolSize是否已满，没满创建线程并执行，满了判断等待队列是否满了，没满进入等待队列，
     * 满了判断maximumPoolSize是否满了，没满创建线程并执行，满了执行拒绝策略
     * <p>
     * 1. corePoolSize = 2，1、2线程首先创建并执行；
     * 2. 3、4线程进入等待队列；
     * 3. 5、6线程创建并执行；
     * 4. 7、8、9、10执行拒绝策略；
     * 5. 等待队列里的3、4线程等待1、2执行完后执行；
     * <p>
     * ☆ 线程执行顺序不是固定的
     */
    private static void initiatorProcedure() throws IOException {
        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        System.in.read(); //阻塞主线程
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
        }
    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                Thread.sleep(3000); //让任务执行慢点
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
