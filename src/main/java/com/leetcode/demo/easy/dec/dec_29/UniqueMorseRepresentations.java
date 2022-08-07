package com.leetcode.demo.easy.dec.dec_29;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println(arr['a' - 97]);

        // 输入: words = ["gin", "zen", "gig", "msg"]
        //输出: 2

        String[] words = {"a"};
        System.out.println(new UniqueMorseRepresentations().uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(morseArr[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
