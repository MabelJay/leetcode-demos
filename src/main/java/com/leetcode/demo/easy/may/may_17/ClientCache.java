package com.leetcode.demo.easy.may.may_17;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCache {

    ConcurrentHashMap<Integer, Bond> map;

    public ClientCache() {
        map = new ConcurrentHashMap<>();
    }

    public void put(Bond bond) {
        int id = bond.bondId;
        map.put(id, bond);
    }

    public Bond get(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        return null;
    }

    public static void main(String[] args) {
        ClientCache cache = new ClientCache();
        cache.put(new Bond(1, 0.11));
        cache.put(new Bond(1, 0.22));
        cache.put(new Bond(2, 0.56));
        cache.put(new Bond(3, 1.10));

        System.out.println(cache.get(2));
    }
}
