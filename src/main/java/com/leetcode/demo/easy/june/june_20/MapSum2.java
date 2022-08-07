package com.leetcode.demo.easy.june.june_20;

import java.util.HashMap;
import java.util.Map;

public class MapSum2 {

    class TrieNode {
        int val;
        TrieNode next[] = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum2() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int data = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode tmpNode = root;
        for (char c : key.toCharArray()) {
            if (tmpNode.next[c - 'a'] == null) {
                tmpNode.next[c - 'a'] = new TrieNode();
            }

            tmpNode = tmpNode.next[c - 'a'];
            tmpNode.val += data;
        }
    }

    public int sum(String prefix) {
        TrieNode tmpNode = root;
        for (char c : prefix.toCharArray()) {
            if (tmpNode.next[c - 'a'] == null) return 0;

            tmpNode = tmpNode.next[c - 'a'];
        }
        return tmpNode.val;
    }
}
