package com.mojito.learn.algorithm.common;

import java.util.LinkedList;

/**
 * 链表相关算法
 *
 * @author liufengqiang
 * @date 2020-11-05 14:04:30
 */
public class ListNodeAlgorithm {

    public static void main(String[] args) {
        linkedList();
    }

    /**
     * 链表实现
     */
    private static void linkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("我是");
        linkedList.add("开发");
        linkedList.add("大神");
        System.out.println(linkedList);

        // 双向链表实现
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("我是");
        myLinkedList.add("开发");
        myLinkedList.add("大神");
        System.out.println(myLinkedList);
    }

    public static class MyLinkedList<E> {

        private int size;
        private Node<E> first;
        private Node<E> last;

        private static class Node<E> {
            E item;
            Node<E> prev;
            Node<E> next;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.prev = prev;
                this.next = next;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "item=" + item +
                        '}';
            }
        }

        public boolean add(E e) {
            // 新增节点插入尾部
            Node<E> l = last;
            // 创建尾结点（next = null为尾结点）
            Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
            return true;
        }

        @Override
        public String toString() {
            return "MyLinkedList{" +
                    "size=" + size +
                    ", first=" + first +
                    ", last=" + last +
                    '}';
        }
    }
}
