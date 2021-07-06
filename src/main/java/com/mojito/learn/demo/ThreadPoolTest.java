package com.mojito.learn.demo;//package com.mojito.learn.test;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * @author liufengqiang
// * @date 2021-01-06 09:59:04
// */
//@Slf4j
//public class ThreadPoolTest {
//
//    public static void main(String[] args) {
////        test1();
////        test2();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("test");
//            }
//        }).start();
//
//        new ThreadPoolExecutor();
//    }
//
//    private static void test2() {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 1; i < 5; i++) {
//            int groupId = i;
//            executorService.execute(() -> {
//                for (int j = 1; j < 5; j++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ignored) {
//                    }
//                    log.info("第 {} 组任务，第 {} 次执行完成", groupId, j);
//                }
//            });
//        }
//        executorService.shutdown();
//    }
//
//    private static void test1() {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 5; i++) {
//            int groupId = i;
//            fixedThreadPool.execute(() -> {
//                for (int j = 0; j < 5; j++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    log.info("第 {} 组任务，第 {} 次执行完成", groupId, j);
//                }
//            });
//        }
//        fixedThreadPool.shutdown();
//    }
//}
