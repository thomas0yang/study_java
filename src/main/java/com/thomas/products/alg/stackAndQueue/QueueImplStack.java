package com.thomas.products.alg.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 */
public class QueueImplStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.empty()); // 返回 true
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.peek()); // 返回 4
        System.out.println(myStack.pop()); // 返回 4
        System.out.println(myStack.peek()); // 返回 3
        System.out.println(myStack.empty()); // 返回 False
    }


    private static class MyStack {
        private Queue<Integer> queue1 = new LinkedList<Integer> ();
        private Queue<Integer>  queue2 = new LinkedList<Integer> ();

        public MyStack() {

        }

        public void push(int x) {
            queue1.offer(x);

            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }

            Queue<Integer>  tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        public Integer pop() {
            return queue2.poll();
        }

        public Integer peek() {
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }
    }
}
