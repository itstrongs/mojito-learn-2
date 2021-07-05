package com.mojito.learn.controller;

import com.mojito.learn.pojo.entity.UserTest;
import com.mojito.learn.service.UserTestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author liufengqiang
 * @date 2021-06-24 14:32:21
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserTestService userTestService;

    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    /**
     * 随机写入一千万数据
     */
    @PostMapping
    public void test1() {
        List<UserTest> userTests = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            UserTest userTest = new UserTest();
            userTest.setMobileNo(telFirst[i % telFirst.length] + String.format("%08d", random.nextInt(100000000)));
            userTests.add(userTest);
        }
//        userTestService
    }
}
