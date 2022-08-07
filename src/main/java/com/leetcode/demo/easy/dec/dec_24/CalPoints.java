package com.leetcode.demo.easy.dec.dec_24;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// 棒球比赛
public class CalPoints {

    public static void main(String[] args) {
        //输入：ops = ["5","2","C","D","+"]
        //输出：30

        // 输入：ops = ["5","-2","4","C","D","9","+","+"]
        //输出：27


        String[] s = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(new CalPoints().calPoints(s));
    }

    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;

        int sum = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s : ops) {
            if (s.equals("C")) {
                sum -= stack.pop();
            } else if (s.equals("D")) {
                int val = stack.peek();
                sum += val * 2;
                stack.push(val * 2);
            } else if (s.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.peek();
                sum += val1 + val2;
                stack.push(val1);
                stack.push(val1 + val2);
            } else {
                int val = Integer.valueOf(s);
                sum += val;
                stack.push(val);
            }
        }

        return sum;
    }
}
