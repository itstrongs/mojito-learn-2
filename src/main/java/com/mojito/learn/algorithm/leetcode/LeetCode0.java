package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.ListNode;
import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.*;

/**
 * 每100题分组
 *
 * @author liufengqiang
 * @date 2021-07-02 17:43:39
 */
public class LeetCode0 {

    /**
     * 1. 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        // 暴力枚举
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
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

    /**
     * 5. 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 存储字符串从任意位置到另一个位置是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int length = 1;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (j - i >= length) {
                        start = i;
                        length = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }

    /**
     * 10. 正则表达式匹配
     */
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[s.length()];
        dp[s.length() - 1] = p.contains(String.valueOf(s.charAt(s.length() - 1)));
        for (int i = 0; i < s.length() - 1; i++) {
//            dp[i] =
        }
        return true;
    }

    /**
     * 20. 有效的括号
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char item : chars) {
            if (stack.isEmpty()) {
                stack.push(item);
                continue;
            }

            Character peek = stack.peek();
            Character c = map.get(item);
            if (c != null) {
                if (c.equals(peek)) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            stack.push(item);
        }
        return stack.isEmpty();
    }

    /**
     * 62. 不同路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 94. 二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}
