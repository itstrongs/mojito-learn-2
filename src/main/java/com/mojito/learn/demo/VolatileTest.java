package com.mojito.learn.demo;

/**
 * @author liufengqiang
 * @date 2020-11-09 09:44:20
 */
public class VolatileTest {

    /**
     * 共享变量，还没用volatile修饰
     */
    public static boolean flag = true;

    public static void main(String[] args) {
        System.out.println("这是" + Thread.currentThread().getName() + "线程开始,flag是 " + flag);
        //开启刚才线程
        new Thread(new Task()).start();
        try {
            //沉睡一秒，确保刚才的线程已经跑到了while循环
            //要不然还没跑到while循环，主线程就将flag变为false
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //改变共享变量flag转为false
        flag = false;
        System.out.println("这是" + Thread.currentThread().getName() + "线程结束,flag是 " + flag);
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("这是" + Thread.currentThread().getName() + "线程开始,flag是 " + VolatileTest.flag);
            //当共享变量是true时,就一直卡在这里，不输出下面那句话
            // 当flag是false时，输出下面这句话
            while (VolatileTest.flag) {

            }
            System.out.println("这是" + Thread.currentThread().getName() + "线程结束,flag是 " + VolatileTest.flag);
        }
    }
}
