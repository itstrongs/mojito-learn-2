package com.mojito.learn.demo.mq;//package com.mojito.learn.demo.mq;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-07-17 17:37
// */
//@Slf4j
//public class Consumer {
//
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-2", selectorExpression = "tag1")
//    public static class MyConsumer1 implements RocketMQListener<String> {
//        @Override
//        public void onMessage(String message) {
//            log.info("接收消息: {}", message);
//        }
//    }
//
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-1", selectorExpression = "tag2")
//    public static class MyConsumer12 implements RocketMQListener<String> {
//        @Override
//        public void onMessage(String message) {
//            log.info("接收消息: {}", message);
//        }
//    }
//
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-22")
//    public static class MyConsumer2 implements RocketMQListener<OrderPaidEvent>{
//        @Override
//        public void onMessage(OrderPaidEvent orderPaidEvent) {
//            log.info("接收消息: {}", orderPaidEvent);
//        }
//    }
//
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-3", consumerGroup = "my-consumer_test-topic-32")
//    public static class MyConsumer3 implements RocketMQListener<String>{
//        @Override
//        public void onMessage(String message) {
//            log.info("接收消息: {}", message);
//        }
//    }
//
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-4", consumerGroup = "my-consumer_test-topic-3")
//    public static class MyConsumer4<T> implements RocketMQListener<MessageExt> {
//        @Override
//        public void onMessage(MessageExt message) {
//            String body = new String(message.getBody());
//            JSONObject jsonObject = JSON.parseObject(body);
//            Long key1 = jsonObject.getLong("key1");
//            log.info("接收消息key1: {}", key1);
//            log.info("接收消息: {}", body);
//        }
//    }
//}
