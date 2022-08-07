package com.leetcode.demo.easy.apr.apr_11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Calculate {

    public static void main(String[] args) {
        // 输入：s = "3+2*2"
        //输出：7

        // 输入：s = " 3+5 / 2 "
        //输出：5

        // "1-1+1"

        //"1*2-3/4+5*6-7*8+9/10"
        // -24
        String s = " 3/2 ";
        System.out.println(new Calculate().calculate4(s));
    }

    public int calculate3(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public int calculate4(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        s = s.replaceAll(" ", "");
        char temp = '+';
        int index = 0;
        while (index < s.length()) {
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            switch (temp) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    int num1 = stack.pop();
                    stack.push(num * num1);
                    break;
                case '/':
                    num1 = stack.pop();
                    stack.push(num1 / num);
                    break;
            }
            if (index == s.length()) break;
            temp = s.charAt(index);
            index++;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int calculate2(String s) {
        s = s.replaceAll(" ", "");
        LinkedList<Integer> stackOperand = new LinkedList<>();
        int index = 0;
        char temp = '+';
        while (index < s.length()) {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            }
            int num = Integer.parseInt(sb.toString());
            if (temp == '+') {
                stackOperand.push(num);
            } else if (temp == '-') {
                stackOperand.push(-num);
            } else if (temp == '*') {
                int num2 = stackOperand.pop();
                stackOperand.push(num2 * num);
            } else {
                int num2 = stackOperand.pop();
                stackOperand.push(num2 / num);
            }
            if (index == s.length()) break;
            temp = s.charAt(index);
            index++;
        }
        int res = 0;
        while (!stackOperand.isEmpty()) {
            res += stackOperand.pop();
        }
        return res;
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        LinkedList<Integer> stackOperand = new LinkedList<>();
        LinkedList<Character> stackOperator = new LinkedList<>();

        int index = 0;
        while (index < s.length()) {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            }
            if (sb.length() > 0) {
                stackOperand.push(Integer.parseInt(sb.toString()));
            }
            if (index == s.length()) break;
            char temp = s.charAt(index);
            while (!stackOperator.isEmpty() && priority(temp) <= priority(stackOperator.peek())) {
                int num1 = stackOperand.pop();
                int num2 = stackOperand.pop();
                char c = stackOperator.pop();
                stackOperand.push(compute(num2, num1, c));
            }
            stackOperator.push(temp);
            index++;
        }
        while (!stackOperator.isEmpty()) {
            int num1 = stackOperand.pop();
            int num2 = stackOperand.pop();
            char c = stackOperator.pop();
            stackOperand.push(compute(num2, num1, c));
        }
        return stackOperand.pop();
    }

    public int priority(char c) {
        if (c == '*' || c == '/') return 1;
        return 0;
    }

    public int compute(int num1, int num2, char c) {
        if (c == '/') return num1 / num2;
        if (c == '+') return num1 + num2;
        if (c == '*') return num1 * num2;
        else return num1 - num2;
    }
}
