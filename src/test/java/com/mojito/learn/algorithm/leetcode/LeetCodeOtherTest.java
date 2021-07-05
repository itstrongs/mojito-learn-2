package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.common.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-04 13:02:51
 */
class LeetCodeOtherTest {

    private TreeAlgorithm treeDemo;
    private LeetCodeOther leetCodeDfs;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeDfs = new LeetCodeOther();
    }

    @Test
    void isBalanced() {
        System.out.println(leetCodeDfs.isBalanced(treeDemo.buildTree("[1,2,2,3,null,null,3,4,null,null,4]", ",")));
    }
}
