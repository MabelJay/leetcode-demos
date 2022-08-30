package com.leetcode.demo.aug_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonChars {

    public static void main(String[] args) {
        // 输入：words = ["bella","label","roller"]
        //输出：["e","l","l"]

        String[] words = {"bella", "label", "roller"};
        System.out.println(new FindCommonChars().commonChars(words));
    }

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) return list;

        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String s : words) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }
}
