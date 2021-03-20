package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.ListNode;
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

    /**
     * 2. 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
//        boolean flag = (l1.val + l2.val) > 9;
//        while (l1.next != null && l2.next != null) {
//            flag = (l1.next.val + l2.next.val) > 9;
//            l3.next = new ListNode(l1.next.val + l2.next.val + 1);
//        }

        ListNode l3 = new ListNode();
        getNodeVal(l1, l2, l3, false);
        return l3;
    }

    private ListNode getNodeVal(ListNode l1, ListNode l2, ListNode l3, boolean flag) {
        if (l1 != null || l2 != null) {
            ListNode listNode = new ListNode();
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flag ? 1 : 0);
            l3.val = val % 10;
            l3.next =
            l3.next = getNodeVal(l1.next, l2.next, l3.next, val > 9);
            return l3;
        }
        return null;
    }
}
