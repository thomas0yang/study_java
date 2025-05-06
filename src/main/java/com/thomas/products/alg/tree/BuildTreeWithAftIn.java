package com.thomas.products.alg.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从后序与中序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 aftorder 和 inorder
 * 其中 afterOrder 是二叉树的后序遍历，（左->右->根）
 * inorder 是同一棵树的中序遍历（左->根->右），请构造二叉树并返回其根节点。
 *
 * 后续遍历是（根->左->右）
 *
 * 示例 1:
 * 输入: preorder = [9,15,7,20,3], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *    3
 *   / \
 *  9   20
 *     / \
 *    15  7
 *
 * 示例 2:
 * 输入: afterOrder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 须知知识点：
 * 1、后序遍历的最后一个元素是根节点。
 * 2、中序遍历的根节点左边的所有元素都在根节点的左字树中，右边的所有元素都在根节点的右子树中。
 * 3、根据中序遍历中的左右子树节点的数量就能确定后序遍历中左右子树的分布。
 */
public class BuildTreeWithAftIn {

    public static void main(String[] args) {
        int[] afterOrder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        BuildTreeWithAftIn buildTreeWithPreIn = new BuildTreeWithAftIn();
        Node node = buildTreeWithPreIn.buildTree(afterOrder, inorder);
        System.out.println(node);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    private Node buildTree(int[] afterOrder, int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(afterOrder, 0, afterOrder.length - 1, 0, inorder.length - 1);
    }

    private Node build(int[] afterOrder,
                       int afterStart, int afterEnd,
                       int inStart, int inEnd){
        if (afterStart > afterEnd) {
            return null;
        }
        int rootVal =  afterOrder[afterEnd];
        Node root = new Node(rootVal);

        int inIndex = inorderMap.get(rootVal);
        int afterRightSize = inEnd - inIndex;

        root.left = build(afterOrder,
                afterStart, afterEnd-afterRightSize-1,
                inStart, inIndex-1);
        root.right = build(afterOrder,
                afterEnd-afterRightSize,afterEnd-1,
                inIndex+1, inEnd
        );
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
