package com.mojito.learn.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-04 17:28:21
 */
class LeetCode15Test {

    private LeetCode15 leetCode;

    @BeforeEach
    void init() {
        leetCode = new LeetCode15();
    }

    @Test
    void numWaterBottles() {
        System.out.println(leetCode.numWaterBottles(15, 4));
    }
}
