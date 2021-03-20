package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liufengqiang
 * @date 2021-03-04 17:28:21
 */
class LeetCodeGreedyAlgorithmTest {

    private LeetCodeGreedyAlgorithm leetCodeGreedyAlgorithm;

    @BeforeEach
    void init() {
        leetCodeGreedyAlgorithm = new LeetCodeGreedyAlgorithm();
    }

    @Test
    void numWaterBottles() {
        System.out.println(leetCodeGreedyAlgorithm.numWaterBottles(15, 4));
    }
}
