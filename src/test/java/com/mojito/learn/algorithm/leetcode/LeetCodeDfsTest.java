package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-04 13:02:51
 */
class LeetCodeDfsTest {

    private TreeAlgorithm treeDemo;
    private LeetCodeDfs leetCodeDfs;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeDfs = new LeetCodeDfs();
    }

    @Test
    void isBalanced() {
        System.out.println(leetCodeDfs.isBalanced(treeDemo.buildTree("[1,2,2,3,null,null,3,4,null,null,4]")));
    }
}
