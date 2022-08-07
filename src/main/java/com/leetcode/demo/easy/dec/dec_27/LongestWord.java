package com.leetcode.demo.easy.dec.dec_27;

import java.util.*;

public class LongestWord {

    public static void main(String[] args) {
        // words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        //输出："apple"

        //["yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"]
        // "yodn"
        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        System.out.println(new LongestWord().longestWord(words));
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";

        int len = words.length;
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);

        int maxLen = 0;
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            boolean flag = true;
            String temp = words[i];
            if (temp.length() < maxLen) continue;
            for (int j = 0; j < temp.length(); j++) {
                if (!set.contains(temp.substring(0, j + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (temp.length() == maxLen) {
                    res = temp.compareTo(res) < 0 ? temp : res;
                } else {
                    maxLen = temp.length();
                    res = temp;
                }
            }
        }
        return res;
    }
}
