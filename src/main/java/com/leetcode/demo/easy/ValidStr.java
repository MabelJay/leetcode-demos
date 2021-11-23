package com.leetcode.demo.easy;

import java.util.LinkedList;

public class ValidStr {
    public static void main(String[] args) {
        String s = "{";
        System.out.println(new ValidStr().isValid(s));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;

        LinkedList<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char peekEle = stack.pop();
                if (temp == ')' && peekEle != '(') {
                    return false;
                }
                if (temp == ']' && peekEle != '[') {
                    return false;
                }
                if (temp == '}' && peekEle != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
