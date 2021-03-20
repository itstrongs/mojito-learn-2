package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-03 23:29:30
 */
class LeetCodeRecursionTest {

    private TreeAlgorithm treeDemo;
    private LeetCodeRecursion leetCodeRecursion;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeRecursion = new LeetCodeRecursion();
    }

    @Test
    void fib() {
        System.out.println(leetCodeRecursion.fib(45));
    }

    @Test
    void findTilt() {
        TreeNode root = treeDemo.buildTree("[1,2,3]");
        System.out.println(leetCodeRecursion.findTilt(root));
    }
}
