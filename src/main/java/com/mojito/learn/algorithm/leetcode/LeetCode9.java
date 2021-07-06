package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liufengqiang
 * @date 2021-03-04 11:05:11
 */
public class LeetCode9 {

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
     * 977. 有序数组的平方
     */
    public int[] sortedSquares(int[] nums) {
        // 简单平方后排序
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);

        //
        return result;
    }
}
