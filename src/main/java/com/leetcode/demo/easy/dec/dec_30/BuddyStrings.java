package com.leetcode.demo.easy.dec.dec_30;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public static void main(String[] args) {
        // 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
        //输出：true

        String s = "abac";
        String goal = "abcd";
        System.out.println(new BuddyStrings().buddyStrings(s, goal));
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (index1 == -1) index1 = i;
                else if (index2 == -1) index2 = i;
                else return false;
            }
        }
        if (index1 == -1) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) return true;
                else {
                    set.add(s.charAt(i));
                }
            }
            return false;
        }
        return index2 != -1 && s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1);
    }
}
