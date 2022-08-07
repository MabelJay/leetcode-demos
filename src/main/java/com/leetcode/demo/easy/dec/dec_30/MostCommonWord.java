package com.leetcode.demo.easy.dec.dec_30;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {
        // paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
        //banned = ["hit"]
        //输出: "ball"

        // "Bob. hIt, baLl"
        //["bob", "hit"]
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int maxCount = 0;
        String res = "";
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String temp = sb.toString();
                if (!set.contains(temp)) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    if (map.get(temp) > maxCount) {
                        maxCount = map.get(temp);
                        res = temp;
                    }
                }
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
