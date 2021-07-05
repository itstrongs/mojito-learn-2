package com.mojito.learn.algorithm.leetcode;

/**
 * 力扣 - 递归
 *
 * @author liufengqiang
 * @date 2021-03-03 23:07:03
 */
public class LeetCode11 {

    /**
     * 1137. 第 N 个泰波那契数
     */
    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        int temp, a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
