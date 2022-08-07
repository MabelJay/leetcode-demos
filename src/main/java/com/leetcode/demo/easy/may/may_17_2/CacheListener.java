package com.leetcode.demo.easy.may.may_17_2;

import java.util.HashMap;
import java.util.Map;

public class CacheListener {

    private ClientCache cache;

    public CacheListener(ClientCache cache) {
        this.cache = cache;
    }

    public void startListener() {
        new Thread(() -> {
            while (true) {
                for (int key : cache.getAllKeys()) {
                    if (cache.isTimeout(key)) {
                        cache.clearByKey(key);
                        System.out.println("key=" + key + " is cleared as timeout");
                    }
                }
            }
        }).start();
    }
}
