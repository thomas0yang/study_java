package com.thomas.products.alg.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree2Link {
    public static void main(String[] args) {

        Node root = new Node(1,
                new Node(2,
                        new Node(3, null, null), new Node(4, null, null)),
                new Node(5,
                        null,  new Node(6,null,null)));

        List<Integer> list = new LinkedList<Integer>();
        process(root, list);
        System.out.println(list);

        List<Integer> list2 = new LinkedList<Integer>();
        treeToList(root, list2);
        System.out.println(list2);
    }


    private static void process(Node node, List<Integer> list){
        if(node != null) {
            list.add(node.getValue());
            process(node.getLeft(), list);
            process(node.getRight(), list);
        }
    }

    public static List<Integer> treeToList(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
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

        public int getValue() {
            return value;
        }


        public Node getLeft() {
            return left;
        }


        public Node getRight() {
            return right;
        }

    }
}
