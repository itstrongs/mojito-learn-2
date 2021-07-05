package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.ListNode;
import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:30:20
 */
public class LeetCode2 {

    /**
     * 206. 反转链表
     */
    public ListNode reverseList(ListNode head) {
        while (head.next != null) {

        }
        return null;
    }

    /**
     * 226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

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

    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化
     */
    private String serialize(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        if (root == null) {
            return level.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    level.add(null);
                } else {
                    level.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return level.toString();
    }

    /**
     * 297. 二叉树的序列化与反序列化
     * 反序列化
     */
    public TreeNode deserialize(String data) {
        if ("[]" .equals(data)) {
            return null;
        }

        List<Integer> vals = Arrays.asList(data.substring(1, data.length() - 1).split(","))
                .stream().map(o -> "null" .equals(o.trim()) ? null : Integer.valueOf(o.trim())).collect(Collectors.toList());
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        int i = 1;
        while (!queue.isEmpty() && i < vals.size()) {
            TreeNode node = queue.poll();
            if (vals.get(i) != null) {
                node.left = new TreeNode(vals.get(i));
                queue.offer(node.left);
            }
            i++;
            if (vals.get(i) != null) {
                node.right = new TreeNode(vals.get(i));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
