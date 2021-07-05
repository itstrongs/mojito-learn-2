package com.mojito.learn.algorithm.interview;

import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 牛客网练习
 *
 * @author liufengqiang
 * @date 2021-04-12 17:24:26
 */
public class NowCoder {

    public int[][] threeOrders(TreeNode root) {
        List<List<Integer>> val = new ArrayList<>();

        List<Integer> val0 = new ArrayList<>();
        print0(root, val0);
        val.add(val0);

        List<Integer> val1 = new ArrayList<>();
        print1(root, val1);
        val.add(val1);

        List<Integer> val2 = new ArrayList<>();
        print2(root, val2);
        val.add(val2);

        int[][] result = new int[3][val0.size()];
        for (int i = 0; i < val.size(); i++) {
            for (int j = 0; j < val0.size(); j++) {
                result[i][j] = val.get(i).get(j);
            }
        }
        return result;
    }

    private void print0(TreeNode root, List<Integer> val) {
        if (root != null) {
            val.add(root.val);
            print0(root.left, val);
            print0(root.right, val);
        }
    }

    private void print1(TreeNode root, List<Integer> val) {
        if (root != null) {
            print1(root.left, val);
            val.add(root.val);
            print1(root.right, val);
        }
    }

    private void print2(TreeNode root, List<Integer> val) {
        if (root != null) {
            print2(root.left, val);
            print2(root.right, val);
            val.add(root.val);
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        ArrayList<ArrayList<Integer>> val = new ArrayList<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> item = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (val.size() % 2 == 0) {
                        item.addLast(node.val);
                    } else {
                        item.addFirst(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            val.add(new ArrayList<>(item));
        }
        return val;
    }

    public int LCS(String str1, String str2) {
        // str1前i个字符和str2前j个字符最大子串
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public int jumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
