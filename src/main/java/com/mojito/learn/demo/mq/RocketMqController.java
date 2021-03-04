package com.mojito.learn.demo.mq;//package com.mojito.learn.demo.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.util.HashMap;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-07-17 15:55
// */
//@Slf4j
//@RestController
//public class RocketMqController {
//
//    @Resource
//    private RocketMQTemplate rocketMQTemplate;
//
//    @GetMapping("/send")
//    public String send() {
//        rocketMQTemplate.convertAndSend("test-topic-1:tag1", "convertAndSend 消息");
//        rocketMQTemplate.send("test-topic-1:tag2", MessageBuilder.withPayload("payload 消息").build());
//        rocketMQTemplate.asyncSend("test-topic-2", new OrderPaidEvent("异步消息", new BigDecimal("88.00")), new SendCallback() {
//            @Override
//            public void onSuccess(SendResult var1) {
//                log.info("消息发送成功{}", var1);
//            }
//
//            @Override
//            public void onException(Throwable var1) {
//                log.error("消息发送失败", var1);
//            }
//
//        });
//        rocketMQTemplate.syncSendOrderly("test-topic-3", MessageBuilder.withPayload("异步顺序发送").build(), "hashkey");
//
//        rocketMQTemplate.syncSend("test-topic-4:tag1", "String");
//        rocketMQTemplate.syncSend("test-topic-4:tag2", 100L);
//        HashMap<String, Long> map = new HashMap<>();
//        map.put("key1", 100L);
//        map.put("key2", 200L);
//        rocketMQTemplate.syncSend("test-topic-4:tag3", map);
//        rocketMQTemplate.syncSend("test-topic-4:tagService", new OrderPaidEvent("异步消息", new BigDecimal("88.00")));
//        return "发送消息";
//    }
//}
