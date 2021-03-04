package com.mojito.learn.algorithm;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

/**
 * description 布隆过滤器
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-10-19 14:03
 */
public class BloomFilterDemo {

    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}
