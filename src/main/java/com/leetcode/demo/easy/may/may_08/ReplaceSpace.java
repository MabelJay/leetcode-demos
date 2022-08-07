package com.leetcode.demo.easy.may.may_08;

public class ReplaceSpace {

    public static void main(String[] args) {
        // 输入：s = "We are happy."
        //输出："We%20are%20happy."

        String s = "We are happy";
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
