package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.common.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-07-02 17:52:12
 */
class LeetCode0Test {

    private LeetCode0 leetCode;
    private TreeAlgorithm treeDemo;

    @BeforeEach
    void init() {
        leetCode = new LeetCode0();
        treeDemo = new TreeAlgorithm();
    }

    @Test
    void isValid() {
        System.out.println(leetCode.isValid("(("));
    }

    @Test
    void inorderTraversal() {
        System.out.println(leetCode.inorderTraversal(treeDemo.buildTree("[1,null,2,3]")));
    }
}
