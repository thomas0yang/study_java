package com.thomas.products.alg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNextPoint {
    public static void main(String[] args) {

        Node root = new Node(1,
                new Node(2,
                        new Node(3, null, null), new Node(4, null, null)),
                new Node(5,
                        null, new Node(6, null, null)));
//        process(root);
//        System.out.println(root); //断点查看

        List<List<Node>> list = new ArrayList<>();
        recurse(root, 0, list);
        for (List<Node> nodes : list) {
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                if (i + 1 < nodes.size()) {
                    node.next = nodes.get(i + 1);
                }
            }
        }
        System.out.println(list);
    }


    /**
     * 非递归实现
     * 利用队列实现二叉树的层次遍历
     *
     * @param node
     * @return
     */
    private static void process(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                //偏移指针
                cur.next = i + 1 == size ? null : queue.peek();

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
    }

    private static void recurse(Node node, int level, List<List<Node>> list) {
        if (node == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(new LinkedList<>());
        }
        List<Node> nodes = list.get(level);
        nodes.add(node);

        recurse(node.left, level + 1, list);
        recurse(node.right, level + 1, list);
    }


    static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;

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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
