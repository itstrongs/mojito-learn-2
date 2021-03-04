package com.mojito.learn.algorithm;

import com.alibaba.fastjson.JSON;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liufengqiang
 * @date 2021-03-04 17:11:33
 */
class TreeAlgorithmTest {

    private TreeAlgorithm treeAlgorithm;
    private TreeNode root;

    @BeforeEach
    void init() {
        treeAlgorithm = new TreeAlgorithm();
        root = treeAlgorithm.buildTree("[1,2,3,4,5,6]");
    }

    @Test
    void maxDeath() {
        System.out.println(treeAlgorithm.maxDeath(root));
    }
}
