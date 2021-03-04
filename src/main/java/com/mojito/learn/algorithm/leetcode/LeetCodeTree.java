package com.mojito.learn.algorithm.leetcode;

/**
 * 力扣 - 树相关
 *
 * @author liufengqiang
 * @date 2021-03-02 11:08:07
 */
public class LeetCodeTree {

    /**
     * 279. 完全平方数
     */
    public int numSquares(int n) {
        // 动态规划

        // 贪心枚举

        // 贪心 + 广度优先搜索：将n减去比n小的所有平方数，直到n为0，此时层数即结果

        // 数学运算：四平方定理，4的k次幂 * (8m + 7)
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        for (int i = 1; i * i <= n; ++i) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }
}
