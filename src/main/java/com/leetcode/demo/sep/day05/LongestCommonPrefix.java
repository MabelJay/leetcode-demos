package com.leetcode.demo.sep.day05;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        // 输入：strs = ["flower","flow","flight"]
        //输出："fl"

        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = commonPre(pre, strs[i]);
        }
        return pre;
    }

    public String commonPre(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        StringBuilder sb = new StringBuilder();
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                sb.append(s1.charAt(index1));
            } else return sb.toString();
            index1++;
            index2++;
        }
        return sb.toString();
    }
}
