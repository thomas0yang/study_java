package com.thomas.products.alg.linkednode;

import java.util.Stack;

public class LinkedReverse {
    public static void main(String[] args) {
        System.out.println("reverse");
        printNode(reverse(initNode()));
        System.out.println("reverseRecursive");
        printNode(reverseRecursive(null, initNode()));
        System.out.println("reverseUseStack");
        printNode(reverseUseStack(initNode()));
        System.out.println("reverseDouble");
        printNode(reverseDouble(initNode()));
        System.out.println("reverseThree");
        printNode(reverseThree(initNode()));
        System.out.println("reverseBetweenLeftAndRight");
        printNode(reverseBetweenLeftAndRight(initNode(),2,4));
    }

    private static Node initNode() {
        Node node = new Node(1, new Node(2, new Node(3,
                new Node(4, new Node(5, new Node(6, null))))));
        return node;
    }

    /**
     * 直接反转
     *
     * @param node
     * @return
     */
    static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        //头插法(推荐)
        //https://blog.csdn.net/Ezrealwj/article/details/119702058
        Node dummyNode = new Node(-1, node); //一个虚拟的head
        Node curNode = node;
        while (curNode.next != null) {
            Node next = curNode.next; //获取next节点
            curNode.next = next.next; //倒序反转，当前节点指针指向next节点的next
            next.next = dummyNode.next; //next节点指向虚拟头的next
            dummyNode.next = next; //虚拟节点指向next节点
        }
        return dummyNode.next;

//       // 三指针法（也叫就地反转法）
//        //已翻转的Node链表
//        Node doneNode = null;
//        //待反转的Node链表
//        Node waitNode = node;
//        while (waitNode != null) {
//            Node nextNode = waitNode.next; //先记录下一轮的首节点，移动next节点;【记录下一个待翻转节点】
//            waitNode.next = doneNode; //直接翻转  【翻转动作1，当前节点的next指向已返转的node链表】
//            doneNode = waitNode;  //移动pre节点   【翻转动作2，将当前节点记录为已返转的node链表】
//            waitNode = nextNode; //移动cur节点【最后一步，记录好的下一个节点赋值给待翻转节点】
//        }
//        return doneNode;
    }

    /**
     * 递归写法
     * @param done
     * @param wait
     * @return
     */
   private static Node reverseRecursive(Node done, Node wait) {
        if (wait == null) return done;
        Node next = wait.next; //记录下个节点
        wait.next = done;      //当前节点指向完成部分，作为新的完成部分
        return reverseRecursive(wait, next);
   }



    /**
     * 部分反转
     * 1234-> 2143
     *
     * @param cur
     * @return
     */
    static Node reverseDouble(Node cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        Node next = cur.next;
        cur.next = reverseDouble(next.next);
        next.next = cur;
        return next;
    }

    /**
     * 123456-> 321654
     * 部分反转2
     *
     * @param node
     * @return
     */
    static Node reverseThree(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        //定义节点
        Node cur = node.next;
        Node next = cur.next;
        //逆序重新定义指针
        node.next = reverseThree(next.next);
        cur.next = node;
        next.next = cur;
        return next;
    }

    /**
     * stack反转
     *
     * @param node
     * @return
     */
    static Node reverseUseStack(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        //待反转的Node链表
        Node curNode = node;
        Stack<Node> stack = new Stack<>();
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }

        Node currNode = stack.pop();
        Node head = currNode;
        while (currNode != null) {
            Node next = stack.isEmpty() ? null : stack.pop();
            currNode.next = next;
            currNode = next;
        }
        return head;
    }

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * <p>
     * 输入：head = [1,2,3,4,5,6], left = 2, right = 4
     * 输出：[1,4,3,2,5,6]
     *
     * 思路：
     * 1、定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * 2、当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5->6,
     * 3、当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     * 4、1->4->3->2->5->6.
     *
     * @param node
     * @param left
     * @param right
     * @return
     */
    private static Node reverseBetweenLeftAndRight(Node node, int left, int right) {
        if (node == null || node.next == null) {
            return node;
        }
        Node dummy = new Node(-1, node);
        Node pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        Node head = pre.next; //此处注意，head一直为left位置的node，无需变换位置
        for (int i = left; i < right; i++) {
            Node next = head.next;
            head.next = next.next;
            next.next = pre.next; //由于head节点不变，所以此处不能next.next = head，而是pre.next
            pre.next = next;
        }
        return dummy.next;
    }

    static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }


    static class Node {
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
