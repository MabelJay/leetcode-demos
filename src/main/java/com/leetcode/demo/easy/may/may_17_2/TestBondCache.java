package com.leetcode.demo.easy.may.may_17_2;

public class TestBondCache {

    public static void main(String[] args) throws InterruptedException {
        ClientCache cache = new ClientCache();
        cache.putCache(1, new Bond(1, 0.01));
        cache.putCache(2, new Bond(2, 0.02), 1000L);
        cache.putCache(3, new Bond(3, 0.03));

        CacheListener listener = new CacheListener(cache);
        listener.startListener();

        System.out.println(cache.getCache(1));
        System.out.println(cache.getCache(2));

        Thread.sleep(1000L);
        System.out.println(cache.getCache(2));
        System.out.println(cache.getCache(1));

        Thread.sleep(10000L);
        System.out.println(cache.getCache(1));
    }
}
