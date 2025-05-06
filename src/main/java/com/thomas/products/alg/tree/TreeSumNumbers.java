package com.thomas.products.alg.tree;


public class TreeSumNumbers {
    public static void main(String[] args) {

        Node root = new Node(4,
                new Node(9,
                        new Node(5, null, null) , new Node(1, null, null)),
                new Node(0,null,null));
        System.out.println(addAllLineNum(root, 0, 0));

        Node root2 = new Node(1,
                new Node(2,null,null),
                new Node(3,null,null));
        System.out.println(addAllLineNum(root2, 0, 0));
    }

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     *
     * 示例1
     * 输入：root = [1,2,3]
     *       1
     *     /  \
     *   2     3
     * 输出：25
     * 解释：
     * 从根到叶子节点路径 1->2 代表数字 12
     * 从根到叶子节点路径 1->3 代表数字 13
     * 因此，数字总和 = 12 + 13 = 25
     *
     * 示例2
     * 输入：root = [4,9,0,5,1]
     *       4
     *     /  \
     *    9    0
     *  /  \
     * 5    1
     * 输出：1026
     * 解释：
     * 从根到叶子节点路径 4->9->5 代表数字 495
     * 从根到叶子节点路径 4->9->1 代表数字 491
     * 从根到叶子节点路径 4->0 代表数字 40
     * 因此，数字总和 = 495 + 491 + 40 = 1026
     * @param node
     * @param addResult
     * @return
     */
    private static int addAllLineNum(Node node, int parent, int addResult){
        if(node != null) {
            int value = node.value;
            parent = parent * 10 + value;
            if (node.left != null) {
                addResult += addAllLineNum(node.left, parent, addResult);
            }
            if (node.right != null) {
                addResult += addAllLineNum(node.right, parent, addResult);
            }
            if (node.left == null && node.right == null){
                addResult = parent;
            }
        }
        return addResult;
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
