package com.leetcode.demo.easy.apr.apr_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalculateExpression3 {

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

        String s = "1-1+1"; //1 2 5 * 3 / 6 4 / 2 *
        // "1+2*5/3+6/4*2"
        // 6
        System.out.println(new CalculateExpression3().calculate(s));
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            char temp = s.charAt(index);
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - 48);
                index++;
            }
            if (temp == '-') stack.push(-num);
            else if (temp == '*') stack.push(stack.pop() * num);
            else if (temp == '/') stack.push(stack.pop() / num);
            else stack.push(num);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
