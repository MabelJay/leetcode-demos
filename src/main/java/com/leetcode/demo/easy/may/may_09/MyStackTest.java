package com.leetcode.demo.easy.may.may_09;

import java.util.LinkedList;

public class MyStackTest {

    static class CQueue {

        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        int size;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
            size = 0;
        }

        public void appendTail(int value) {
            stack1.push(value);
            size++;
        }

        public int deleteHead() {
            if (size == 0) return -1;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
            size--;
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        // 输入：
        //["CQueue","appendTail","deleteHead","deleteHead"]
        //[[],[3],[],[]]
        //输出：[null,null,3,-1]

        /*CQueue queue = new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());*/
        // 输入：
        //["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        //[[],[],[5],[2],[],[]]
        //输出：[null,-1,null,null,5,2]

        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
