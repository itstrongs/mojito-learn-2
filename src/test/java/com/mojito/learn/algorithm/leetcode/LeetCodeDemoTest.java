package com.mojito.learn.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import com.mojito.learn.algorithm.TreeAlgorithm;
import com.mojito.learn.algorithm.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-02-28 10:48:33
 */
class LeetCodeDemoTest {

    private TreeAlgorithm treeDemo;
    private LeetCodeDemo leetCodeDemo;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeDemo = new LeetCodeDemo();
    }

    @Test
    void tree2str() {
        String val = "[1,2,3,4]";
        System.out.println("根据二叉树创建字符串：" + leetCodeDemo.tree2str(treeDemo.buildTree(val)));
    }

    @Test
    void invertTree() {
        String val = "[4,2,7,1,3,6,9]";
        TreeNode root = leetCodeDemo.invertTree(treeDemo.buildTree(val));
        System.out.println(JSON.toJSONString(treeDemo.bfs(root)));
    }

    @Test
    void kthLargest() {
        String val = "[5,3,6,2,4,null,null,1]";
        System.out.println(leetCodeDemo.kthLargest(treeDemo.buildTree(val), 3));
    }

    @Test
    void hasPathSum() {
        String val = "[1,2,3,4,5,6]";
        TreeNode root = treeDemo.buildTree(val);
        boolean result = leetCodeDemo.hasPathSum(root, 7);
        System.out.println(result);
    }
}
