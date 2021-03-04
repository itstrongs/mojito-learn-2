package com.mojito.learn.algorithm.datastructure;

import java.util.List;

/**
 * N叉树
 *
 * @author liufengqiang
 * @date 2021-02-28 00:27:47
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
