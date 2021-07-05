package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:30:52
 */
public class LeetCode8 {

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
