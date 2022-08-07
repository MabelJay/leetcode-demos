package com.leetcode.demo.easy.may.may_03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {
    public static void main(String[] args) {
        // 输入：num = "1432219", k = 3
        //输出："1219"

        String num = "1432219";
        System.out.println(new RemoveKdigits().removeKdigits(num, 3));
//        System.out.println(String.valueOf(Integer.MAX_VALUE).length());

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        System.out.println(stack.pop());
        System.out.println(stack.pollLast());

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2.pollFirst());
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        int index = 0;
        while (index < num.length()) {
            while (!stack.isEmpty() && num.charAt(index) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        while (k > 0) {
            k--;
            stack.pop();
        }
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollLast();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
