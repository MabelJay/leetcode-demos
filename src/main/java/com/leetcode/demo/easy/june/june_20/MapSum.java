package com.leetcode.demo.easy.june.june_20;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    Map<String, Integer> map;
    Map<String, Integer> prefixMap;

    public MapSum() {
        map = new HashMap<>();
        prefixMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int data = val - map.getOrDefault(key, 0);
        map.put(key, val);

        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + data);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
}