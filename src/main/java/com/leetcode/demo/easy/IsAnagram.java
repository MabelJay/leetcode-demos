package com.leetcode.demo.easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class IsAnagram {
    public static void main(String[] args) {
        //输入: s = "anagram", t = "nagaram"
        //输出: true

        String s = "aa", t = "bb";
        System.out.println(new IsAnagram().isAnagram(s, t));

    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int len1 = s.length(), len2 = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < len2; i++) {
            if (map.containsKey(t.charAt(i))) {
                int count = map.get(t.charAt(i));
                map.put(t.charAt(i), count - 1);
            } else {
                return false;
            }
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        map.values().forEach(val -> {
            if (val != 0) {
                flag.set(false);
            }
        });
        return flag.get();
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int len1 = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < len1; i++) {
            if (map.containsKey(t.charAt(i))) {
                int count = map.get(t.charAt(i));
                if (count < 1) return false;
                map.put(t.charAt(i), count - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int len1 = s.length();

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < len1; i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < len1; i++) {
            if (list.contains(t.charAt(i))) {
                list.remove(Character.valueOf(t.charAt(i)));
            } else {
                return false;
            }
        }
        return list.isEmpty();
    }

    public boolean isAnagram4(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int len = s.length();
        int sum1 = 1;
        int sum2 = 1;

        int multiVal1 = 1;
        int multiVal2 = 1;
        for (int i = 0; i < len; i++) {
            sum1 += s.charAt(i);
            sum2 += t.charAt(i);

            multiVal1 *= s.charAt(i);
            multiVal2 *= t.charAt(i);
        }
        return (sum1 == sum2) && (multiVal1 == multiVal2);
    }

    public boolean isAnagram5(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram6(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
