package com.leetcode.demo.easy.apr.apr_09;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        // 输入：s = "the sky is blue"
        //输出："blue is sky the"

        // 输入：s = "  hello world  "
        //输出："world hello"

        String s = "  hello world  ";
        System.out.println(new ReverseWords().reverseWords(s));
        System.out.println(s.length());
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
