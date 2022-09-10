package com.leetcode.demo.sep_10;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams2(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) return list;
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            List<String> tmpList = map.getOrDefault(temp, new ArrayList<>());
            tmpList.add(str);
            map.put(temp, tmpList);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) return list;
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char) ('a' + i));
                    sb.append(arr[i]);
                }
            }
            String key = sb.toString();
            List<String> tmpList = map.getOrDefault(key, new ArrayList<>());
            tmpList.add(str);
            map.put(key, tmpList);
        }
        return new ArrayList<>(map.values());
    }
}
