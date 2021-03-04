package com.mojito.learn.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-04 11:33:55
 */
class LeetCodeMathTest {

    private LeetCodeMath leetCodeMath;

    @BeforeEach
    void init() {
        leetCodeMath = new LeetCodeMath();
    }

    @Test
    void checkPerfectNumber() {
        System.out.println(leetCodeMath.checkPerfectNumber(1));
    }
}
