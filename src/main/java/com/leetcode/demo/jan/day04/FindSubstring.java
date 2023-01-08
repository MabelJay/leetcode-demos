package com.leetcode.demo.jan.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {

    public static void main(String[] args) {
        //输入：s = "barfoothefoobarman", words = ["foo","bar"]
        //输出：[0,9]

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new FindSubstring().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null) return list;

        int m = words.length;
        int n = words[0].length();
        int ls = s.length();

        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) break;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) - 1);
                if (map.get(word) == 0) map.remove(word);
            }

            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) == 0) {
                        map.remove(word);
                    }

                    word = s.substring(start - n, start);
                    map.put(word, map.getOrDefault(word, 0) - 1);
                    if (map.get(word) == 0) map.remove(word);
                }

                if (map.isEmpty()) list.add(start);
            }
        }
        return list;
    }
}
