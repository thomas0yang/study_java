package com.thomas.products.alg.tree;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *         3
 *      /    \
 *     5      1
 *   /  \    /  \
 *  6    2  0    8
 *     /  \
 *    7    4
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 */
public class TreeLowestCommonParent {
    public static void main(String[] args) {

        Node root = new Node(3,
                new Node(5,
                        new Node(6, null, null),
                        new Node(2,
                                new Node(7, null, null),
                                new Node(4, null, null))),
                new Node(1,
                        new Node(0, null, null),
                        new Node(8,null,null))
                );

        System.out.println(lowestCommonParent(root, root.left, root.right)); //5,1 -> 3
        System.out.println(lowestCommonParent(root, root.left, root.left.right.right)); //5,4 -> 5
        System.out.println(lowestCommonParent(root, root.left, root.left.right.right)); //5,9 -> 5
    }


    private static Node lowestCommonParent(Node root, Node p , Node q){
        if (root == null) {
            return null;
        }
        //最大公共父节点，最近的也就是自己了
        if(root == p || root == q) {
            return root;
        }

        Node left = lowestCommonParent(root.left, p, q);
        Node right = lowestCommonParent(root.right, p, q);
        //前提是两个节点必须存在，如不存在则也认为为父节点
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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
                    '}';
        }
    }
}
