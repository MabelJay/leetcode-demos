package com.leetcode.demo.easy;

public class FindLUSlength {

    public static void main(String[] args) {
        //"aefeaf"
        //"a"
        System.out.println(new FindLUSlength().findLUSlength("aaa", "aaa"));
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
