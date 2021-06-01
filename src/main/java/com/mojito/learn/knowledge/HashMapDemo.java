package com.mojito.learn.knowledge;

import java.util.HashMap;

/**
 * HashMap 源码分析
 *
 * @author liufengqiang
 * @date 2021-05-22 13:13:33
 */
public class HashMapDemo {

    public static void main(String[] args) {
        // 创建 HashMap 实例，初始容量【initialCapacity】和负载因子【loadFactor】可以通过构造方法传入，不传负载因子设置默认值 0.75，
        // 如果传入初始容量，通过 tableSizeFor 方法把初始容量转成2的 n 次方，
        HashMap<String, String> map = new HashMap<>();

        // 首先计算 key 的 hash 值【hash 值计算】
        // hash 值计算
        map.put("key0", "value0");
        map.put("key0", "value0");
        System.out.println(map);

        System.out.println(tableSizeFor(33));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
