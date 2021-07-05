package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.common.TreeAlgorithm;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-02-28 10:48:33
 */
class LeetCode1Test {

    private TreeAlgorithm treeDemo;
    private LeetCode1 leetCodeDemo;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeDemo = new LeetCode1();
    }

    @Test
    void hasPathSum() {
        String val = "[1,2,3,4,5,6]";
        TreeNode root = treeDemo.buildTree(val, ",");
        boolean result = leetCodeDemo.hasPathSum(root, 7);
        System.out.println(result);
    }
}
