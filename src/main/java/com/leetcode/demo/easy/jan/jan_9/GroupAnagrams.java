package com.leetcode.demo.easy.jan.jan_9;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        //
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        if (strs == null || strs.length == 0) return resList;

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> tmpList = map.getOrDefault(key, new ArrayList<>());
            tmpList.add(s);
            map.put(key, tmpList);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        if (strs == null || strs.length == 0) return resList;

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int index = s.charAt(i) - 'a';
                count[index]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }

            String key = sb.toString();
            List<String> tmpList = map.getOrDefault(key, new ArrayList<>());
            tmpList.add(s);
            map.put(key, tmpList);
        }

        return new ArrayList<>(map.values());
    }
}
