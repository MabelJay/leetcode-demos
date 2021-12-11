package com.leetcode.demo.easy;

import java.util.*;

public class FindDiffInStr {

    public static void main(String[] args) {
        //输入：s = "abcd", t = "abcde"
        //输出："e"
        System.out.println(new FindDiffInStr().findTheDifference6("aa", "aaa"));
    }

    public char findTheDifference(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len2 - len1 != 1) return ' ';

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) return arr2[i];
        }
        return arr2[len1];
    }

    public char findTheDifference2(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len2 - len1 != 1) return ' ';

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < len2; i++) {
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);
            } else {
                return temp;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return entry.getKey();
        }
        return ' ';
    }

    public char findTheDifference3(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len2 - len1 != 1) return ' ';

        char[] arr = new char[26];
        for (int i = 0; i < len2; i++) {
            arr[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < len1; i++) {
            arr[s.charAt(i) - 97]--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1) return (char) (i + 97);
        }

        return ' ';
    }

    public char findTheDifference4(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len2 - len1 != 1) return ' ';

        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            char temp = s.charAt(i);
            arr[temp - 97]++;
        }

        for (int i = 0; i < len2; i++) {
            char temp = t.charAt(i);
            arr[temp - 97]--;
            if (arr[temp - 97] < 0) return temp;
        }
        return ' ';
    }

    public char findTheDifference5(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }

        return (char) sum;
    }

    public char findTheDifference6(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return (char) (res ^ t.charAt(s.length()));
    }
}
