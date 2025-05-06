package com.thomas.products.alg.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeMinDiff {
    public static void main(String[] args) {

        Node root = new Node(5,
                new Node(3,
                        new Node(0, null, null), new Node(6, null, null)),
                new Node(8,
                        null,  new Node(11,null,null)));

        System.out.println(minDiff(root, Integer.MAX_VALUE));
    }


    /**
     * 530. 二叉搜索树的最小绝对差
     * 简单
     *
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     *
     */
    private static int minDiff(Node node, int min){
        if(node != null) {
            int value = node.value;
            Node left = node.left;
            Node right = node.right;
            if(left != null) {
                min = Math.min(min, value-left.value);
            }
            if(right != null) {
                min = Math.min(min, right.value-value);
            }
            min = Math.min(
                   minDiff(node.left, min),
                   minDiff(node.right, min));
        }
        return min;
    }

    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
