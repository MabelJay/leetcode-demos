package com.leetcode.demo.easy.may.may_31;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
        LinkedList<Integer> operandStack = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String s : tokens) {
            if (set.contains(s)) {
                int res = cal(operandStack.pop(), operandStack.pop(), s);
                operandStack.push(res);
            } else {
                operandStack.push(Integer.parseInt(s));
            }
        }
        return operandStack.pop();
    }

    public int cal(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            default:
                return num2 / num1;
        }
    }
}
