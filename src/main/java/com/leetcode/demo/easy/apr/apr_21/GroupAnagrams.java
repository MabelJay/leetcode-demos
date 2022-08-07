package com.leetcode.demo.easy.apr.apr_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] tmpArr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                tmpArr[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (tmpArr[i] > 0) {
                    sb.append(tmpArr[i]).append(i + 'a');
                }
            }
            String key = sb.toString();
            List<String> tmpList = map.getOrDefault(key, new ArrayList<>());
            tmpList.add(str);
            map.put(key, tmpList);
        }
        return new ArrayList<>(map.values());
    }

    //  Map<String, List<String>> map = new HashMap<>();
    //        for (String str : strs) {
    //            StringBuilder sb = new StringBuilder();
    //            int[] arr = new int[26];
    //            for (int i = 0; i < str.length(); i++) {
    //                arr[str.charAt(i) - 'a']++;
    //            }
    //            for (int i = 0; i < 26; i++) {
    //                if (arr[i] > 0) {
    //                    sb.append((char) (i + 'a'));
    //                    sb.append(arr[i]);
    //                }
    //            }
    //            String key = sb.toString();
    //            List<String> tmpList = map.getOrDefault(key, new ArrayList<>());
    //            tmpList.add(str);
    //            map.put(key, tmpList);
    //        }
    //        return new ArrayList<>(map.values());
    //    }
}
