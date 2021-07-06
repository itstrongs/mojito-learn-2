package com.mojito.learn.algorithm.leetcode;

/**
 * @author liufengqiang
 * @date 2021-03-02 10:01:00
 */
public class LeetCode15 {

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
