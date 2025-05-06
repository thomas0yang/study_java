package com.thomas.products.alg.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *    3
 *   / \
 *  9   20
 *     / \
 *    15  7
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 须知知识点：
 * 1、前序遍历的第一个元素是根节点。
 * 2、中序遍历的根节点左边的所有元素都在根节点的左字树中，右边的所有元素都在根节点的右子树中。
 * 3、根据中序遍历中的左右子树节点的数量就能确定前序遍历中左右子树的分布。
 */
public class BuildTreeWithPreIn {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTreeWithPreIn buildTreeWithPreIn = new BuildTreeWithPreIn();
        Node node = buildTreeWithPreIn.buildTree(preorder, inorder);
        System.out.println(node);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    private Node buildTree(int[] preorder, int[] inorder){

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private Node build(int[] preorder,
                       int preStart, int preEnd,
                       int inStart, int inEnd){
        if (preStart > preEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        Node root = new Node(rootValue);

        // 中序的索引位置,其左边的都是root的左子树，其右边的都是root的右子树
        Integer inIndex = inorderMap.get(rootValue);
        int newLeftInStart = inStart;
        int newLeftInEnd = inIndex - 1;
        int newRightInStart = inIndex + 1;
        int newRightInEnd = inEnd;

        // 前序中左子树的大小=中序左子树的大小，因为是一棵树
        int leftSize = inIndex - inStart;
        int newLeftPreStart = preStart + 1; //排除自己根节点
        int newLeftPreEnd = preStart + leftSize;
        int newRightPreStart = preStart + leftSize + 1;
        int newRightPreEnd = preEnd;

        root.left = build(preorder, newLeftPreStart, newLeftPreEnd, newLeftInStart, newLeftInEnd);
        root.right = build(preorder, newRightPreStart, newRightPreEnd, newRightInStart, newRightInEnd);

//        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, inIndex - 1);
//        root.right = build(preorder, preStart + leftSize + 1, preEnd, inIndex + 1, inEnd);

        return root;
    }



    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
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
