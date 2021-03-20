package com.mojito.learn.algorithm.leetcode;

/**
 * 力扣 - 贪心算法
 *
 * @author liufengqiang
 * @date 2021-03-02 10:01:00
 */
public class LeetCodeGreedyAlgorithm {

    /**
     * 455. 分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        return 0;
    }

    /**
     * 1518. 换酒问题
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int num = empty / numExchange;
            result += num;
            empty = empty % numExchange + num;
        }
        return result;
    }
}
