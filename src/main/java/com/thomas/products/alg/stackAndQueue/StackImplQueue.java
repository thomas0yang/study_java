package com.thomas.products.alg.stackAndQueue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
 *
 * 既然题目给了我们两个栈，我们可以这样考虑当 push 的时候将元素 push 进 stack1，pop 的时候我们先把 stack1 的元素 pop 到 stack2，然后再对 stack2 执行 pop 操作，这样就可以保证是先进先出的。（负[pop]负[pop]得正[先进先出]）
 * ------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/the-sword-refers-to-offer.html
 */
public class StackImplQueue {
    public static void main(String[] args) {

        push(1);
        push(2);
        System.out.println(pop());
        push(3);
        System.out.println(pop());
        System.out.println(pop());
    }


    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    private static void push(Integer number){
        stack1.push(number);
    }

    private static Integer pop(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }



}
