package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.Stack;

/**
 * 力扣 - 递归
 *
 * @author liufengqiang
 * @date 2021-03-03 23:07:03
 */
public class LeetCodeRecursion {

    private int result;

    /**
     * 938. 二叉搜索树的范围和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 深度优先搜索迭代实现
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= low && node.val <= high) {
                    result += node.val;
                }
                if (node.val > low) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }

        // 深度优先搜索递归实现
        dfs(root, low, high);
        return result;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            result += node.val;
        }
        if (node.val > low) {
            dfs(node.left, low, high);
        }
        if (node.val < high) {
            dfs(node.right, low, high);
        }
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 563. 二叉树的坡度
     */
    public int findTilt(TreeNode root) {
        count(root);
        return result;
    }

    /**
     * 任意节点的子树和
     */
    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);
        result += Math.abs(left - right);
        return node.val + left + right;
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
}
