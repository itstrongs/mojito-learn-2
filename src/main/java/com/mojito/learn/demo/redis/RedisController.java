package com.mojito.learn.demo.redis;//package com.charles.learn.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-04-20 14:19
// */
//@Controller
//@Slf4j
//public class RedisController {
//
//    @Autowired
//    RedisLock redisLock;
//
//    int count = 0;
//    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
//
//    @RequestMapping("/index")
//    @ResponseBody
//    public String index() throws InterruptedException {
//
//        int clientcount =1000;
//        CountDownLatch countDownLatch = new CountDownLatch(clientcount);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
//        long start = System.currentTimeMillis();
//        for (int i = 0;i<clientcount;i++){
//            executorService.execute(() -> {
//                //通过Snowflake算法获取唯一的ID字符串
//                String id = String.valueOf(idWorker.nextId());
//                try {
//                    redisLock.lock(id);
//                    count++;
//                }finally {
//                    redisLock.unlock(id);
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        long end = System.currentTimeMillis();
//        log.info("执行线程数:{},总耗时:{},count数为:{}",clientcount,end-start,count);
//        return "Hello";
//    }
//}
