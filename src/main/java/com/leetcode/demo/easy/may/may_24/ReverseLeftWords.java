package com.leetcode.demo.easy.may.may_24;

public class ReverseLeftWords {

    public static void main(String[] args) {
        // 输入: s = "abcdefg", k = 2
        //输出: "cdefgab"

        // 输入: s = "lrloseumgh", k = 6
        //输出: "umghlrlose"

        String s = "lrloseumgh";
        System.out.println(new ReverseLeftWords().reverseLeftWords(s, 6));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s, n, s.length());
        sb.append(s, 0, n);
        return sb.toString();
    }
}
