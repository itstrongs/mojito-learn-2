package com.mojito.learn.algorithm.datastructure;

/**
 * 链表
 *
 * @author liufengqiang
 * @date 2021-02-28 00:40:29
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
