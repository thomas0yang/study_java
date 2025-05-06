package com.thomas.products.alg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelPrint {
    public static void main(String[] args) {

        Node root = new Node(1,
                new Node(2,
                        new Node(3, null, null), new Node(4, null, null)),
                new Node(5,
                        null,  new Node(6,null,null)));

        List<List<Node>> list = process(root);
        System.out.println(list);

        List<List<Node>> list2 = levelOrder(root);
        System.out.println(list2);

    }


    /**
     * 非递归实现
     * 利用队列实现二叉树的层次遍历
     * @param node
     * @return
     */
    private static List<List<Node>>  process(Node node){
        List<List<Node>> resultList = new ArrayList<>();
        if (node == null) return resultList;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Node> currentList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                currentList.add(currentNode);
                if (currentNode.getLeft() != null){
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null){
                    queue.add(currentNode.getRight());
                }
            }
            resultList.add(currentList);
        }
        return resultList;
    }


    /**
     * 递归实现
     * @param root
     * @return
     */
    private static List<List<Node>> levelOrder(Node root) {
        List<List<Node>> result = new ArrayList<>();
        recurse(root, 0, result);
        return result;
    }

    private static void recurse(Node node, int level, List<List<Node>> result) {
        if (node == null) {
            return;
        }

        // 如果当前层数已经超过结果列表的大小，说明是新的一层
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        // 将当前节点的值添加到对应层级的列表中
        result.get(level).add(node);

        // 递归遍历左子树，层数增加
        recurse(node.getLeft(), level + 1, result);
        // 递归遍历右子树，层数增加
        recurse(node.getRight(), level + 1, result);
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
