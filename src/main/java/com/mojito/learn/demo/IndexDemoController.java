package com.mojito.learn.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description 索引测试
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-27 18:02
 */
@RestController
@Slf4j
public class IndexDemoController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/index")
    public String index() {
        long start = System.currentTimeMillis();
        jdbcTemplate.query("select * from demo_index where score < 20 limit 50", (set) -> {
        });
        long end = System.currentTimeMillis();
        log.info("调用事件：{}", end - start);
        return "success";
    }
}
