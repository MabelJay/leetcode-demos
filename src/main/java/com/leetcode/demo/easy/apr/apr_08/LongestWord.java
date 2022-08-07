package com.leetcode.demo.easy.apr.apr_08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    public static void main(String[] args) {
        // ["cat","banana","dog","nana","walk","walker","dogwalker"]
        //输出： "dogwalker"
        //解释： "dogwalker"可由"dog"和"walker"组成。

        String[] words = {"cat", "banana", "dog", "nana", "walk", "walker", "walkerdog", "dogwalker"};
        String[] word2 = {""};

        // ["llllcccl","clclll","ccc","llccllccl","lcclccclcl","c"]
        // ccc
        String[] words3 = {"llllcccl", "clclll", "ccc", "llccllccl", "lcclccclcl", "c"};
//        System.out.println(new LongestWord().longestWord(words));
//        System.out.println(new LongestWord().longestWord(word2));
        System.out.println(new LongestWord().longestWord(words));
    }

    public String longestWord(String[] words) {
        if (words == null || words.length < 2) return "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (o1, o2) -> {
            if (o2.length() == o1.length()) return o1.compareTo(o2);
            return o2.length() - o1.length();
        });

        System.out.println(Arrays.toString(words));

        for (String s : words) {
            char[] arr = s.toCharArray();
            if (find(arr, 0, set)) return new String(arr);
        }
        return "";
    }

    public boolean containsOtherWord(String s, Set<String> set) {
        StringBuilder sb1 = new StringBuilder("" + s.charAt(0));
        StringBuilder sb2 = new StringBuilder(s.substring(1));
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(sb1.toString()) && set.contains(sb2.toString())) return true;
            sb1.append(s.charAt(i));
            sb2.deleteCharAt(0);
        }
        return false;
    }

    public boolean find(char[] charArr, int index, Set<String> set) {
        if (index == charArr.length) return true;

        for (int i = index; i < charArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(charArr, index, i - index + 1);
            if (index == 0 && i == charArr.length-1) return false;
            if (set.contains(sb.toString())) {
                if (find(charArr, i + 1, set)) return true;
            }
        }
        return false;
    }
}
