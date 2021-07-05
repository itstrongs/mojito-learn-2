package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

/**
 * 力扣刷题
 *
 * @author liufengqiang
 * @date 2021-02-27 23:36:51
 */
public class LeetCode1 {

    /**
     * 101. 对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 104. 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 112. 路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int i = hasPathSum1(root);
        return i == targetSum;
    }

    private int hasPathSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + hasPathSum1(root.left) + hasPathSum1(root.right);
    }
}
