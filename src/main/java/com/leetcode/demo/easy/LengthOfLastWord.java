package com.leetcode.demo.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        System.out.println(new LengthOfLastWord().lengthOfLastWord2(s));
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = s.length() - 1;
        int lenRes = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            lenRes++;
        }
        return lenRes;
    }
}
