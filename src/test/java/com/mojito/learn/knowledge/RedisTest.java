package com.mojito.learn.knowledge;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * redis 基本用法
 * @author liufengqiang
 * @date 2021-05-18 17:00:01
 */
class RedisTest {

    @Test
    void jedis() {
        Jedis jedis = new Jedis("192.168.137.151", 6379);
        jedis.auth("nRDPkyJWKgRNo1j4M48=");
        jedis.setex("jedis-test-key", 100L, "hello jedis!");
        System.out.println(jedis.get("jedis-test-key"));
        jedis.close();
    }
}
