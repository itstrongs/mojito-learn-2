package com.mojito.learn.demo.lock;//package com.mojito.learn.demo.lock;
//
//import com.mojito.learn.demo.redis.RedisUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-10-14 16:32
// */
//@RestController
//@RequestMapping("/lock")
//@Slf4j
//public class LockController {
//
//    @Resource
//    private RedisUtils redisUtils;
//
//    /**
//     * 总库存
//     */
//    private long nKuCuen = 0;
//    /**
//     * 商品key名字
//     */
//    private String shangpingKey = "computer_key";
//    /**
//     * 获取锁的超时时间 秒
//     */
//    private int timeout = 30 * 1000;
//
//    /**
//     * springboot + redis 分布式锁-模拟抢单
//     *
//     * @return
//     * @see https://www.cnblogs.com/wangrudong003/p/10627539.html
//     */
//    @GetMapping("/qiangdan")
//    public List<String> qiangdan() {
//        //抢到商品的用户
//        List<String> shopUsers = new ArrayList<>();
//
//        //构造很多用户
//        List<String> users = IntStream.range(0, 100000).boxed().map(o -> "神牛-" + o).collect(Collectors.toList());
//
//        //初始化库存
//        nKuCuen = 10;
//
//        //模拟开抢
//        users.parallelStream().forEach(b -> {
//            String shopUser = qiang(b);
//            if (!StringUtils.isEmpty(shopUser)) {
//                shopUsers.add(shopUser);
//            }
//        });
//
//        return shopUsers;
//    }
//
//    /**
//     * 模拟抢单动作
//     */
//    private String qiang(String b) {
//        //用户开抢时间
//        long startTime = System.currentTimeMillis();
//
//        //未抢到的情况下，30秒内继续获取锁
//        while ((startTime + timeout) >= System.currentTimeMillis()) {
//            //商品是否剩余
//            if (nKuCuen <= 0) {
//                break;
//            }
//            if (redisUtils.setnx(shangpingKey, b)) {
//                //用户b拿到锁
//                log.info("用户{}拿到锁...", b);
//                try {
//                    //商品是否剩余
//                    if (nKuCuen <= 0) {
//                        break;
//                    }
//
//                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    //抢购成功，商品递减，记录用户
//                    nKuCuen -= 1;
//
//                    //抢单成功跳出
//                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, nKuCuen);
//
//                    return b + "抢单成功，所剩库存：" + nKuCuen;
//                } finally {
//                    log.info("用户{}释放锁...", b);
//                    //释放锁
//                    redisUtils.delnx(shangpingKey, b);
//                }
//            } else {
//                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
//            }
//        }
//        return "";
//    }
//}
