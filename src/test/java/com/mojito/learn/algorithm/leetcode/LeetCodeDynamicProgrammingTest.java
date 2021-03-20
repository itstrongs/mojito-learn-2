package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liufengqiang
 * @date 2021-03-04 17:45:06
 */
class LeetCodeDynamicProgrammingTest {

    private LeetCodeDynamicProgramming leetCodeDynamicProgramming;

    @BeforeEach
    void init() {
        leetCodeDynamicProgramming = new LeetCodeDynamicProgramming();
    }

    @Test
    void waysToStep() {
        System.out.println(leetCodeDynamicProgramming.waysToStep(61));
    }

    @Test
    void coinChange() {
        System.out.println(leetCodeDynamicProgramming.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    void uniquePaths() {
        System.out.println(leetCodeDynamicProgramming.uniquePaths(3, 7));
    }

    @Test
    void longestPalindrome() {
        System.out.println(leetCodeDynamicProgramming.longestPalindrome("aaaa"));
    }
}
