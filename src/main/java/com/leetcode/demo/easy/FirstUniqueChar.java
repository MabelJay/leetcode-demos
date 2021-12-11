package com.leetcode.demo.easy;

import java.util.*;

public class FirstUniqueChar {

    public static void main(String[] args) {
        //s = "leetcode"
        //返回 0
        String s = "loveleetcode";
        System.out.println(new FirstUniqueChar().firstUniqueChar(s));
    }

    public int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) return -1;

        char[] arr = new char[128];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            arr[cs[i]]++;
        }

        for (int i = 0; i < cs.length; i++) {
            if (arr[cs[i]] == 1) return i;
        }
        return -1;
    }

    public int firstUniqueChar2(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public int firstUniqueChar3(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, -1);
            } else {
                map.put(temp, i);
            }
        }

        int first = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (index < first && index != -1) {
                first = index;
            }
        }

        return first == s.length() ? -1 : first;
    }

    public int firstUniqueChar4(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
