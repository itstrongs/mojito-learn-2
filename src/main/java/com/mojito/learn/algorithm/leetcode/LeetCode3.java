package com.mojito.learn.algorithm.leetcode;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:41:57
 */
public class LeetCode3 {

    /**
     * 322. 零钱兑换
     */
    public int coinChange(int[] coins, int amount) {
        // 存储最少用多少枚硬币拼出amount
        int[] val = new int[amount + 1];
        val[0] = 0;
        for (int i = 1; i <= amount; i++) {
            val[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && val[i - coin] != Integer.MAX_VALUE) {
                    val[i] = Math.min(val[i - coin] + 1, val[i]);
                }
            }
        }
        if (val[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return val[amount];
    }
}
