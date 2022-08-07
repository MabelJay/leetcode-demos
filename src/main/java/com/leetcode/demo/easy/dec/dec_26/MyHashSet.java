package com.leetcode.demo.easy.dec.dec_26;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashSet {
    LinkedList[] arr;
    private static int len = 101;

    public MyHashSet() {
        arr = new LinkedList[101];
        for (int i = 0; i < len; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = arr[hash].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (key == element) return;
        }
        arr[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = arr[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                arr[hash].remove(Integer.valueOf(key));
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = arr[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) return true;
        }
        return false;
    }

    public int hash(int key) {
        return key % len;
    }
}