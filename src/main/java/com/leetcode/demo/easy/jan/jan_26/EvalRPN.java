package com.leetcode.demo.easy.jan.jan_26;

import java.util.LinkedList;

public class EvalRPN {

    public static void main(String[] args) {

        // 输入：tokens = ["2","1","+","3","*"]
        //输出：9

        // 输入：tokens = ["4","13","5","/","+"]
        //输出：6

        // 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        //输出：22

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isOperator(token) == 0) {
                stack.push(Integer.valueOf(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (isOperator(token) == 1) stack.push(num1 + num2);
                else if (isOperator(token) == 2) stack.push(num2 - num1);
                else if (isOperator(token) == 3) stack.push(num1 * num2);
                else stack.push(num2 / num1);
            }
        }
        return stack.peek();
    }

    public int isOperator(String token) {
        if (token.equals("+")) return 1;
        if (token.equals("-")) return 2;
        if (token.equals("*")) return 3;
        if (token.equals("/")) return 4;
        return 0;
    }
}
