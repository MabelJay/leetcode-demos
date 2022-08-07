package com.leetcode.demo.easy.may.may_31;

public class IsAnagram {

    public static void main(String[] args) {
        // 输入: s = "anagram", t = "nagaram"
        //输出: true

        // 输入: s = "rat", t = "car"
        //输出: false

        String s = "rat";
        String t = "car";
        System.out.println(new IsAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.equals(t) || s.length() != t.length())
            return false;

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            cnt[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            cnt[index]--;
            if (cnt[index] < 0) return false;
        }
        return true;
    }
}
