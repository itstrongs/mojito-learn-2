package com.mojito.learn.algorithm.leetcode;

/**
 * 动态规划
 *
 * @author liufengqiang
 * @date 2021-03-04 17:33:15
 */
public class LeetCodeDynamicProgramming {

    /**
     * 面试题 08.01. 三步问题
     */
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 746. 使用最小花费爬楼梯
     */
    public int minCostClimbingStairs(int[] cost) {
        return 0;
    }

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

    /**
     * 62. 不同路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 5. 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 存储字符串从任意位置到另一个位置是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int length = 1;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (j - i >= length) {
                        start = i;
                        length = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }
}
