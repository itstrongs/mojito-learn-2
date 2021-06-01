package com.mojito.learn.knowledge;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程池的使用
 *
 * @author liufengqiang
 * @date 2021-05-18 16:13:45
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。创建线程池的时候请使用带ThreadFactory的构造函数，并且提供自定义ThreadFactory实现或者使用第三方实现。
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        singleThreadPool.shutdown();
    }
}
