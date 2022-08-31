package com.leetcode.demo.aug_31;

import java.util.LinkedList;

public class BracketsIsValid {

    public static void main(String[] args) {
        String str = "()[]{";
        System.out.println(new BracketsIsValid().isValid(str));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else {
                if (stack.isEmpty()) return false;
                char peekVal = stack.peek();
                if (tmp == ')' && peekVal == '(') stack.pop();
                else if (tmp == ']' && peekVal == '[') stack.pop();
                else if (tmp == '}' && peekVal == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
