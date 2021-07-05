package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.common.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:37:38
 */
class LeetCodeOffer0Test {

    private TreeAlgorithm treeDemo;
    private LeetCodeOffer0 leetCode;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCode = new LeetCodeOffer0();
    }

    @Test
    void kthLargest() {
        String val = "[5,3,6,2,4,null,null,1]";
        System.out.println(leetCode.kthLargest(treeDemo.buildTree(val, ","), 3));
    }
}
