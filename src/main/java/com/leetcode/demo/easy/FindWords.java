package com.leetcode.demo.easy;

import java.util.*;

public class FindWords {

    public static void main(String[] args) {
        //第一行由字符 "qwertyuiop" 组成。
        //第二行由字符 "asdfghjkl" 组成。
        //第三行由字符 "zxcvbnm" 组成。
        String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
        String[] str2 = {"a", "b"};
        System.out.println(Arrays.toString(new FindWords().findWords2(str2)));
    }

    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }

        for (int i = 0; i < s3.length(); i++) {
            set3.add(s3.charAt(i));
        }

        int index = 0;
        String[] res = new String[words.length];
        for (String s : words) {
            if (isSubSeq(set1, s) || isSubSeq(set2, s) || isSubSeq(set3, s)) {
                res[index++] = s;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public boolean isSubSeq(Set<Character> set, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (!set.contains(t.charAt(i)) && !set.contains(Character.toLowerCase(t.charAt(i)))) return false;
        }
        return true;
    }

    public String[] findWords2(String[] words) {
        List<String> list = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
