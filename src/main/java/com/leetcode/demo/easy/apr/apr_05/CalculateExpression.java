package com.leetcode.demo.easy.apr.apr_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CalculateExpression {

    public static void main(String[] args) {
        // 输入: "3+2*2"
        //输出: 7
        // 322*+

        // operator: + - * /

        // 输入: " 3+5 / 2 "
        //输出: 5

        // 23+7-6/2
        char a = '0';
//        System.out.println(a - 48);
//        System.out.println((char) 57);

        String s = "1+2*5/3+6/4*2"; //1 2 5 * 3 / 6 4 / 2 *
        // "1+2*5/3+6/4*2"
        // 6
        System.out.println(new CalculateExpression().calculate(s));
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        List<String> expression = convertStrToList(s);
        List<String> postfixExp = parseToPostfix(expression);
        System.out.println(postfixExp);
        return cal(postfixExp);
    }

    public int cal(List<String> postfixExp) {
        LinkedList<String> stack = new LinkedList<>();
        for (String item : postfixExp) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = compute(num2, num1, item);
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public List<String> parseToPostfix(List<String> list) {
        List<String> postfixList = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                postfixList.add(item);
            } else {
                if (stack.isEmpty() || priority(stack.peek()) < priority(item)) {
                    stack.push(item);
                } else {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(item)) {
                        postfixList.add(stack.pop());
                    }
                    stack.push(item);
                }
            }
        }

        while (!stack.isEmpty()) {
            postfixList.add(stack.pop());
        }
        return postfixList;
    }

    public List<String> convertStrToList(String expression) {
        int index = 0;
        int num = 0;
        List<String> list = new ArrayList<>();
        while (index < expression.length()) {
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                num = num * 10 + (expression.charAt(index) - 48);
                index++;
            }
            list.add("" + num);
            if (index == expression.length()) break;
            list.add("" + expression.charAt(index));
            index++;
            num = 0;
        }
        return list;
    }

    public int compute(int num1, int num2, String operand) {
        if (operand.equals("/")) return num1 / num2;
        if (operand.equals("*")) return num1 * num2;
        if (operand.equals("+")) return num1 + num2;
        else return num1 - num2;
    }

    public int priority(String c) {
        if (c.equals("*") || c.equals("/")) return 1;
        return 0;
    }
}
