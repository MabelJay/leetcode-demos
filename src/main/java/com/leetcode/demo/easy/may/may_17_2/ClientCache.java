package com.leetcode.demo.easy.may.may_17_2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCache {
    private static Map<Integer, BondCache> cacheMap = new ConcurrentHashMap<>();

    public void putCache(int key, Bond bond) {
        BondCache entity = new BondCache(bond, System.currentTimeMillis());
        putCache(key, entity);
    }

    public void putCache(int key, Bond bond, long timeout) {
        BondCache entity = new BondCache(bond, System.currentTimeMillis(), timeout);
        putCache(key, entity);
    }

    public Bond getCache(int key) {
        if (cacheMap.containsKey(key)) return cacheMap.get(key).getBond();
        return null;
    }

    public Map<Integer, BondCache> getAllCache() {
        return cacheMap;
    }

    public boolean contains(int key) {
        return cacheMap.containsKey(key);
    }

    public void clearAll() {
        cacheMap.clear();
    }

    public void clearByKey(int key) {
        if (cacheMap.containsKey(key)) cacheMap.remove(key);
    }

    public boolean isTimeout(int key) {
        if (!cacheMap.containsKey(key)) return true;
        BondCache entity = cacheMap.get(key);
        long timeout = entity.getTimeout();
        long lastUpdatedTime = entity.getLastUpdatedTime();
        if (timeout == 0 || System.currentTimeMillis() - lastUpdatedTime >= timeout) {
            return true;
        }
        return false;
    }

    public Set<Integer> getAllKeys() {
        return cacheMap.keySet();
    }

    private void putCache(int key, BondCache entity) {
        cacheMap.put(key, entity);
    }
}
