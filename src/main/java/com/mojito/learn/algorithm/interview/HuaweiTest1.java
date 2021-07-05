package com.mojito.learn.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2021-04-23 21:02:34
 */
public class HuaweiTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HuaweiTest1 main = new HuaweiTest1();

        TreeNode treeNode = main.buildTree(input);
        System.out.println(main.topic0(treeNode));
    }

    public String topic0(TreeNode root) {
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }

        StringBuilder sb = new StringBuilder();
        getChild(root, sb);
        return sb.toString().substring(1);
    }

    private void getChild(TreeNode node, StringBuilder sb) {

        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        getChild(node.left, sb);
        getChild(node.right, sb);
        sb.append(" ").append(node.val);
    }

    public TreeNode buildTree(String val) {
        List<Integer> vals = Arrays.stream(val.split(" "))
                .map(o -> "null".equals(o.trim()) ? null : Integer.parseInt(o.trim())).collect(Collectors.toList());
        List<TreeNode> nodeList = new LinkedList<>();
        vals.forEach(o -> nodeList.add(o == null ? null : new TreeNode(o)));

        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < vals.size() / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = vals.size() / 2 - 1;
        if (lastParentIndex >= 0) {
            // 左孩子
            nodeList.get(lastParentIndex).left = nodeList
                    .get(lastParentIndex * 2 + 1);
            // 右孩子,如果数组的长度为奇数才建立右孩子
            if (vals.size() % 2 == 1) {
                nodeList.get(lastParentIndex).right = nodeList
                        .get(lastParentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }

    private static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
