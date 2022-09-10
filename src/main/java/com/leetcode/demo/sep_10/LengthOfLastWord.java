package com.leetcode.demo.sep_10;

public class LengthOfLastWord {

    public static void main(String[] args) {
        // 输入：s = "Hello World"
        //输出：5
        // 输入：s = "   fly me   to   the moon  "
        //输出：4

        // 输入：s = "luffy is still joyboy"
        //输出：6

        String s = "luffy is still joyboy ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        int len = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            len++;
            index--;
        }
        return len;
    }
}
