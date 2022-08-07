package com.leetcode.demo.easy.apr.apr_12;

import java.util.LinkedList;

public class IsValid {

    public static void main(String[] args) {
        // 输入：s = "()[]{}"
        //输出：true

        // 输入：s = "(]"
        //输出：false

        // 输入：s = "([)]"
        //输出：false

        // 输入：s = "{[]}"
        //输出：true

        String s = "}";
        System.out.println(new IsValid().isValid(s));
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) return false;
                if (temp == ')' && stack.pop() != '(') return false;
                if (temp == ']' && stack.pop() != '[') return false;
                if (temp == '}' && stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    // if (s == null || s.length() == 0) return false;
    //
    //        LinkedList<Character> stack = new LinkedList<>();
    //        int len = s.length();
    //        for (int i = 0; i < len; i++) {
    //            char temp = s.charAt(i);
    //            if (temp == '(' || temp == '[' || temp == '{') {
    //                stack.push(temp);
    //            } else if (stack.isEmpty()) {
    //                return false;
    //            } else {
    //                char peekEle = stack.pop();
    //                if (temp == ')' && peekEle != '(') {
    //                    return false;
    //                }
    //                if (temp == ']' && peekEle != '[') {
    //                    return false;
    //                }
    //                if (temp == '}' && peekEle != '{') {
    //                    return false;
    //                }
    //            }
    //        }
    //        return stack.isEmpty();
}
