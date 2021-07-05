package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

/**
 * 力扣 - 深度优先搜索
 *
 * @author liufengqiang
 * @date 2021-03-04 12:52:51
 */
public class LeetCodeOther {

    /**
     * 面试题 04.04. 检查平衡性
     * 解法：自底向上
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(high(root.left) - high(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 面试题 04.04. 检查平衡性
     * 解法：自顶向下（性能更好），类似后序遍历
     */
    public boolean isBalanced2(TreeNode root) {
        return high2(root) >= 0;
    }

    private int high2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = high2(root.left);
        int right = high2(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 任意节点的高度
     */
    private int high(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(high(node.left), high(node.right)) + 1;
    }

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
}
