package com.mojito.learn.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liufengqiang
 * @date 2020-12-13 15:20:03
 */
public class CommonTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key1", "val1");
        System.out.println(map);
    }
}
