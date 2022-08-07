package com.leetcode.demo.easy.may.may_19;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println(cache2.get(1));
        cache2.put(3, 3);
        System.out.println(cache2.get(2));
    }
}
