package com.thomas.products.alg.linkednode;


/**
 * 题目描述剑指 offer: 输入一个链表，输出该链表中倒数第 k 个结点。
 * 问题分析 链表中倒数第 k 个节点也就是正数第(L-K+1)个节点，知道了只一点，这一题基本就没问题！
 * 首先两个节点/指针，一个节点 node1 先开始跑，指针 node1 跑到 k-1 个节点后，
 * 另一个节点 node2 开始跑，当 node1 跑到最后时，node2 所指的节点就是倒数第 k 个节点也就是正数第(L-K+1)个节点。
 * <p>
 * 问题分析2 首先两个节点/指针，node1指针跑到k-1, node2开始跑，两者一直相差k个节点，
 * 所以node1到最后，node2就是倒数第k个节点
 * ------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/linkedlist-algorithm-problems.html
 */
public class LinkedBackwardK {

    public static void main(String[] args) {
        Node node = getNode();

//        System.out.println(findKthToTail(node, 2).val);
//        System.out.println(findKthToTail(node, 5).val);
//        System.out.println(findKthToTail(node, 6).val);
//        System.out.println(findKthToTail(node,7));
//        printNode(removeNthFromEnd(node,5));

        printNode(rotateRight(getNode(), 2));
    }

    private static Node getNode() {
        Node node = new Node(1, new Node(2, new Node(3,
                new Node(4, new Node(5, new Node(6, null))))));
        return node;
    }


    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * 输入：head = [1,2,3,4,5,6], k = 2
     * 输出：[5,6,1,2,3,4]
     * @param node
     * @param k
     * @return
     */
    private static Node rotateRight(Node node, int k) {
        if (node == null || k <= 0) {
            return null;
        }
        Node node1 = node;
        Node node2 = node; //最终指向第k个节点
        Node dummy = new Node(-1, node);
        for (int i = 0; i < k; i++) {
            node1 = node1.next;
        }

        Node endNode = node1;
        while (node1.next != null) {
            node1 = node1.next;
            if (node1.next == null) {
                endNode = node1;
            }
            node2 = node2.next;
        }

        endNode.next = dummy.next;
        dummy.next = node2.next;
        node2.next = null;
        return dummy.next;
    }

    private static Node findKthToTail(Node node, int k) {
        if (node == null || k <= 0) {
            return null;
        }
        Node node1 = node;
        Node node2 = node;

        int step = 0;
        int index = k;
        while (node1 != null) {
            node1 = node1.next;
            step++;
            k--;
            if (k < 0) {
                node2 = node2.next;
            }
        }

        if (step < index) {
            return null;
        }
        return node2;
    }
    private static Node removeNthFromEnd(Node node, int k) {
        if (node == null || k <= 0) {
            return null;
        }
        Node node1 = node;
        Node node2 = node;
        Node node3 = node;

        int step = 0;
        int index = k;
        while (node1 != null) {
            node1 = node1.next;
            step++;
            k--;
            if (k < 0) {
                node3 = node2;
                node2 = node2.next;
            }
        }

        if (step < index) {
            return null;
        }

        node3.next = node2.next;

        return node;
    }


    private static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
