package com.leetcode.demo.easy.may.may_17;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheClient2 extends LinkedHashMap<Integer, Bond> {

    int capacity;

    private CacheClient2(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Bond> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        CacheClient2 cache = new CacheClient2(3);
        cache.put(1, new Bond(1, 0.44));
        cache.put(2, new Bond(2, 0.45));
        cache.put(3, new Bond(3, 0.46));
        System.out.println(cache.get(1));
        cache.put(4, new Bond(4, 1.10));
        System.out.println(cache);
        System.out.println(cache.get(2));
    }
}
