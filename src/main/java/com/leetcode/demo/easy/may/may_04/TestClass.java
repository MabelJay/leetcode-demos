package com.leetcode.demo.easy.may.may_04;

import java.util.*;

public class TestClass {

    static class LRUCache extends LinkedHashMap<Integer, Integer> {

        public int capacity;

        public LRUCache(int capacity) {
            super(16, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache);
        System.out.println(cache.get(2));

        SortedMap<Integer, Integer> map = new TreeMap<>();
        System.out.println(map.put(2,2));
        System.out.println(map.put(1,1));
        System.out.println(map.firstKey());
    }
}
