package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指offer 前100题
 *
 * @author liufengqiang
 * @date 2021-07-05 10:29:14
 */
public class LeetCodeOffer0 {

    private Integer index;
    private int k;
    private int value;

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 递归 + 动态规划
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000007;
        }
        return fib[n];
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 1; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> val = new ArrayList<>();
        if (root == null) {
            return val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            LinkedList<Integer> line = new LinkedList<>();
            for (int i = 1; i <= queueSize; i++) {
                TreeNode node = queue.poll();
                if (val.size() % 2 == 0) {
                    line.addLast(node.val);
                } else {
                    line.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            val.add(line);
        }
        return val;
    }

    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     */
    public int kthLargest(TreeNode root, int k) {
        index = 0;
        this.k = k;
        dfs(root);
        return value;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (++index == k) {
            value = root.val;
            return;
        }
        dfs(root.left);
    }
}
