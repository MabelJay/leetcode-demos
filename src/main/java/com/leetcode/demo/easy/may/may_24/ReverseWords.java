package com.leetcode.demo.easy.may.may_24;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        // 输入: "the sky is blue"
        //输出: "blue is sky the"

        // 输入: "  hello world!  "
        //输出: "world! hello"

        //输入: "a good   example"
        //输出: "example good a"

        String s = "  hello world!  ";
        System.out.println(new ReverseWords().reverseWords2(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] splits = s.split(" ");
        System.out.println(Arrays.toString(splits));

        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            if (!splits[i].equals("")) {
                sb.append(splits[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
