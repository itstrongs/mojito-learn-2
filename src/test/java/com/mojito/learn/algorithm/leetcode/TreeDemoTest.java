package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-02-28 23:21:27
 */
class TreeDemoTest {

    private TreeAlgorithm treeDemo;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
    }

    @Test
    void inOrderTraverse() {
        String val = "[1,2,3,4,5,6,7]";
        TreeNode root = treeDemo.buildTree(val);
        treeDemo.preOrderTraverse(root);
    }
}
