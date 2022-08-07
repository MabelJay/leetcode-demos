package com.leetcode.demo.easy.may.may_07_01;

public class SubStr {

    public static void main(String[] args) {
        // s = "abcde"
        // [a, bb, ace, acd]

        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};

        // s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
        System.out.println(new SubStr().subStrCount(words, s));

        // 输入：s = "abc", t = "ahbgdc"
        //输出：true
        System.out.println(new SubStr().isSubsequence("axc", "ahbgdc"));
    }

    public int subStrCount(String[] words, String s) {
        int count = 0;
        for (String str : words) {
            if (str.length() > s.length()) continue;
            int index1 = 0;
            int index2 = 0;
            while (index2 < s.length()) {
                if (s.charAt(index2) == str.charAt(index1)) {
                    index1++;
                    index2++;
                    if (index1 == str.length()) {
                        count++;
                        break;
                    }
                } else {
                    index2++;
                }
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
                if (index1 == s.length()) {
                    return true;
                }
            } else {
                index2++;
            }
        }
        return false;
    }
}
