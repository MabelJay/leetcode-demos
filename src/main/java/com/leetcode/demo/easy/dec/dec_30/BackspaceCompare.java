package com.leetcode.demo.easy.dec.dec_30;

import java.util.LinkedList;
import java.util.Set;

public class BackspaceCompare {

    public static void main(String[] args) {
        //输入：s = "ab#c", t = "ad#c"
        //输出：true
        //解释：S 和 T 都会变成 “ac”。

        // "bbbextm"
        //"bbb#extm"
        String s = "bbbextm";
        String t = "bbb#extm";
        System.out.println(new BackspaceCompare().backspaceCompare3(s, t));
    }

    public boolean backspaceCompare(String s, String t) {
        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();
        int maxLen = Math.max(s.length(), t.length());
        for (int i = 0; i < maxLen; i++) {
            if (i < s.length()) {
                if (s.charAt(i) == '#') {
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                } else {
                    stack1.push(s.charAt(i));
                }
            }
            if (i < t.length()) {
                if (t.charAt(i) == '#') {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                } else {
                    stack2.push(t.charAt(i));
                }
            }
        }

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.pop() != stack2.pop()) return false;
            }
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public boolean backspaceCompare2(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char temp = str.charAt(i);
            if (temp != '#') {
                sb.append(temp);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare3(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                char temp = s.charAt(i);
                if (temp == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                char temp = t.charAt(j);
                if (temp == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
