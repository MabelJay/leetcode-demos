package com.leetcode.demo.easy.apr.apr_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalculateExpression2 {

    public static void main(String[] args) {
        // 输入: " 3+5 / 2 "
        //输出: 5
        String s = "1+1-1";
        System.out.println(new CalculateExpression2().calculate(s));
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();

        int index = 0;
        int num = 0;
        while (index < s.length()) {
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - 48);
                index++;
            }
            stack1.push(num);
            num = 0;
            if (index == s.length()) break;
            if (stack2.isEmpty() || priority(stack2.peek()) < priority(s.charAt(index))) {
                stack2.push(s.charAt(index));
            } else {
                while (!stack2.isEmpty() && priority(stack2.peek()) >= priority(s.charAt(index))) {
                    int num1 = stack1.pop();
                    int num2 = stack1.pop();
                    stack1.push(compute(num2, num1, stack2.pop()));
                }
                stack2.push(s.charAt(index));
            }
            index++;
        }

        while (!stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack1.pop();
            stack1.push(compute(num2, num1, stack2.pop()));
        }
        return stack1.pop();
    }

    public int compute(int num1, int num2, char operator) {
        if (operator == '*') return num1 * num2;
        if (operator == '/') return num1 / num2;
        if (operator == '+') return num1 + num2;
        else return num1 - num2;
    }

    public int priority(char operator) {
        if (operator == '*' || operator == '/') return 1;
        return 0;
    }
}
