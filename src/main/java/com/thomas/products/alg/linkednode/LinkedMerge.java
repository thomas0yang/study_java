package com.thomas.products.alg.linkednode;

import java.util.Stack;

/**
 * 合并两个排序的链表题目
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 问题分析我们可以这样分析:
 * 假设我们有两个链表 A,B；
 * A 的头节点 A1 的值与 B 的头结点 B1 的值比较，假设 A1 小，则 A1 为头节点；
 * A2 再和 B1 比较，假设 B1 小,则，A1 指向 B1；
 * A2 再和 B2 比较 就这样循环往复就行了，应该还算好理解。
 * ------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/linkedlist-algorithm-problems.html
 */
public class LinkedMerge {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(3, new Node(6,null)));
        Node node2 = new Node(2, new Node(4, new Node(5,null)));

        printNode(merge(node,node2));
    }


    private static Node merge(Node node1, Node node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if (node1.val <= node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }


    private static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    static class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
