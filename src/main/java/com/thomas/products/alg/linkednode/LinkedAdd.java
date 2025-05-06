package com.thomas.products.alg.linkednode;

/**
 * Leetcode:给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
 * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LinkedAdd {

    public static void main(String[] args) {
        Node node1 = new Node(1, new Node(3, new Node(6,null)));
        Node node2 = new Node(2, new Node(4, new Node(5,null)));
        System.out.println(add(node1, node2));
    }

    private static Node add(Node node1, Node node2){
        Node resultNode = null;
        Node tmpNode = null;
        Node node1Head = node1;
        Node node2Head = node2;
        int jinwei = 0;

        while (node1Head != null || node2Head != null || jinwei > 0){
            int val1 = node1Head == null ? 0 : node1Head.val;
            int val2 = node2Head == null ? 0 : node2Head.val;
            int sum = val1 + val2 + jinwei;
            jinwei = sum / 10;
            if (resultNode == null) {
                resultNode = new Node(sum % 10, null);
                tmpNode =  resultNode;
            } else {
                tmpNode.next = new Node(sum % 10, null);
                tmpNode = tmpNode.next;
            }
            node1Head = node1Head == null ? null : node1Head.next;
            node2Head = node2Head == null ? null : node2Head.next;
        }
        return resultNode;
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
