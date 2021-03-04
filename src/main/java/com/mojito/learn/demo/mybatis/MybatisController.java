package com.mojito.learn.demo.mybatis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 13:51
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Resource
    private UserService userService;

    @GetMapping("/annotation/{userId}")
    public Object annotation(@PathVariable Long userId) {
        return userService.findByUserIdAndAnnotation(userId);
    }

    @GetMapping("/xml/{userId}")
    public Object xml(@PathVariable Long userId) {
        return userService.findByUserIdAndXml(userId);
    }
}
