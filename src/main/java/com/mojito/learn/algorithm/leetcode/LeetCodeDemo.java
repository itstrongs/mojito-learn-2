package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.Node;
import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 力扣刷题
 *
 * @author liufengqiang
 * @date 2021-02-27 23:36:51
 */
public class LeetCodeDemo {

    private Integer index;
    private int k;
    private int value;

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
     * 606. 根据二叉树创建字符串
     */
    public String tree2str(TreeNode t) {
        String str = tree2str2(t, false);
        return str.substring(1, str.length() - 1);
    }

    private String tree2str2(TreeNode t, boolean isRight) {
        if (t == null) {
            return isRight ? "" : "()";
        }
        if (t.left == null && t.right == null) {
            return "(" + t.val + ")";
        } else {
            return "(" + t.val + tree2str2(t.left, false) + tree2str2(t.right, true) + ")";
        }
    }

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
     * 872. 叶子相似的树
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        getSimilar(root1, val1);
        getSimilar(root2, val2);
        return val1.equals(val2);
    }

    /**
     * 获取叶子节点
     */
    private void getSimilar(TreeNode root, List<Integer> val) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            val.add(root.val);
        }
        getSimilar(root.left, val);
        getSimilar(root.right, val);
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
        if ("[]".equals(data)) {
            return null;
        }

        List<Integer> vals = Arrays.asList(data.substring(1, data.length() - 1).split(","))
                .stream().map(o -> "null".equals(o.trim()) ? null : Integer.valueOf(o.trim())).collect(Collectors.toList());
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
     * 206. 反转链表
     */
//    public ListNode reverseList(ListNode head) {
//        while (head.next!=null) {
//            head.
//        }
//    }

    /**
     * 589. N叉树的前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        getChild(root, vals);
        return vals;
    }

    private void getChild(Node node, List<Integer> vals) {
        vals.add(node.val);
        node.children.forEach(o -> getChild(o, vals));
    }

    /**
     * 897. 递增顺序查找树
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        increasing(root, vals);

        TreeNode treeNode = new TreeNode(0), temp = treeNode;
        for (int val : vals) {
            temp.right = new TreeNode(val);
            temp = temp.right;
        }
        return treeNode.right;
    }

    private void increasing(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        increasing(node.left, vals);
        vals.add(node.val);
        increasing(node.right, vals);
    }
}
