package com.leetcode.demo.easy.dec.dec_30;

import java.util.*;

public class UncommonFromSentences {

    public static void main(String[] args) {
        // 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
        //输出：["sweet","sour"]

        // [gw, pk, xy]
        //[gw, aje, zqd]

        //"gw pk xy"
        //"gw aje zqd"
        String s1 = "gw pk xy";
        String s2 = "gw aje zqd";
        System.out.println(Arrays.toString(new UncommonFromSentences().uncommonFromSentences2(s1, s2)));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        Map<String, Integer> map = new HashMap<>();
        int maxLen = Math.max(arr1.length, arr2.length);
        for (int i = 0; i < maxLen; i++) {
            if (i < arr1.length) {
                String temp = arr1[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            if (i < arr2.length) {
                String temp = arr2[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        String[] resArr = new String[arr1.length + arr2.length];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                resArr[index++] = entry.getKey();
            }
        }
        return Arrays.copyOfRange(resArr, 0, index);
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
