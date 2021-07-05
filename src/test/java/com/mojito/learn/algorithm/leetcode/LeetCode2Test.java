package com.mojito.learn.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import com.mojito.learn.algorithm.common.TreeAlgorithm;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:36:33
 */
class LeetCode2Test {

    private TreeAlgorithm treeDemo;
    private LeetCode2 leetCode;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCode = new LeetCode2();
    }

    @Test
    void invertTree() {
        String val = "[4,2,7,1,3,6,9]";
        TreeNode root = leetCode.invertTree(treeDemo.buildTree(val, ","));
        System.out.println(JSON.toJSONString(treeDemo.bfs(root)));
    }
}
