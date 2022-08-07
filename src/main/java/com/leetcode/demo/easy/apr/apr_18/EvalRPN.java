package com.leetcode.demo.easy.apr.apr_18;

import java.util.LinkedList;

public class EvalRPN {

    public static void main(String[] args) {
        // 输入：tokens = ["2","1","+","3","*"]
        //输出：9
        //解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

        // 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        //输出：22

        String s1 = "+-*/";
        System.out.println(s1.contains("+"));
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> operandStack = new LinkedList<>();
        String operators = "+-*/";
        for (String str : tokens) {
            if (operators.contains(str)) {
                int num2 = operandStack.pop();
                int num1 = operandStack.pop();
                operandStack.push(compute(num1, num2, str));
            } else {
                operandStack.push(Integer.parseInt(str));
            }
        }
        return operandStack.peek();
    }

    public int compute(int num1, int num2, String operator) {
        if (operator.equals("+")) return num1 + num2;
        if (operator.equals("-")) return num1 - num2;
        if (operator.equals("/")) return num1 / num2;
        else return num1 * num2;
    }

    // public int evalRPN(String[] tokens) {
    //        if (tokens == null || tokens.length == 0) return 0;
    //        LinkedList<Integer> stack = new LinkedList<>();
    //        for (String token : tokens) {
    //            if (isOperator(token) == 0) {
    //                stack.push(Integer.valueOf(token));
    //            } else {
    //                int num1 = stack.pop();
    //                int num2 = stack.pop();
    //                if (isOperator(token) == 1) stack.push(num1 + num2);
    //                else if (isOperator(token) == 2) stack.push(num2 - num1);
    //                else if (isOperator(token) == 3) stack.push(num1 * num2);
    //                else stack.push(num2 / num1);
    //            }
    //        }
    //        return stack.peek();
    //    }
    //
    //    public int isOperator(String token) {
    //        if (token.equals("+")) return 1;
    //        if (token.equals("-")) return 2;
    //        if (token.equals("*")) return 3;
    //        if (token.equals("/")) return 4;
    //        return 0;
    //    }
}
