package com.leetcode.demo.easy.jan.jan_27;

import java.util.*;

public class ReverseWords {

    public static void main(String[] args) {
        // 输入：s = "the sky is blue"
        //输出："blue is sky the"

        String s = " a good   example";
        System.out.println(new ReverseWords().reverseWords(s));
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        LinkedList<String> stack = new LinkedList<>();

        int index = 0;

        while (index < len) {
            while (index < len && s.charAt(index) == ' ') {
                index++;
            }
            StringBuilder sb = new StringBuilder();
            while (index < len && s.charAt(index) != ' ') {
                sb.append(s.charAt(index));
                index++;
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
                stack.push(" ");
            }
        }

        StringBuilder res = new StringBuilder();
        if (!stack.isEmpty()) stack.pop();
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            res.append(temp);
        }
        return res.toString();
    }

    public String reverseWords3(String s) {
        if (s == null || s.length() == 0) return s;
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                sb.append(split[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
