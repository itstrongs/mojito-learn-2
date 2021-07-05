package com.mojito.learn.algorithm.interview;

import com.alibaba.fastjson.JSON;
import com.mojito.learn.algorithm.common.TreeAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-04-12 17:39:54
 */
class NowCoderTest {

    private TreeAlgorithm treeDemo;
    private NowCoder nowCoder;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        nowCoder = new NowCoder();
    }

    @Test
    void threeOrders() {
        int[][] ints = nowCoder.threeOrders(treeDemo.buildTree("{1,2,3}", ","));
        System.out.println(JSON.toJSONString(ints));
    }

    @Test
    void zigzagLevelOrder() {
        System.out.println(nowCoder.zigzagLevelOrder(treeDemo.buildTree("{3,9,20,null,null,15,7}", ",")));
    }

    @Test
    void LCS() {
        System.out.println(nowCoder.LCS("1AB2345CD", "12345EF"));
    }
}
