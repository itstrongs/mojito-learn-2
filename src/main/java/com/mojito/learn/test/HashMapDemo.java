package com.mojito.learn.test;

import java.util.HashMap;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-26 15:32
 */
public class HashMapDemo {

    public static void main(String[] args) {
        int a = 17 * 4 / 3;
        HashMap<String, String> map = new HashMap<>(16 * 4 / 3);
        for (int i = 0; i < 16; i++) {
            map.put("key" + i, String.valueOf(i));
        }
        System.out.println(map);
    }
}
