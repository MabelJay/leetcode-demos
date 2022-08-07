package com.leetcode.demo.easy.apr.apr_21;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSetTest {

    static class MyHashSet {

        LinkedList[] arr;
        private static final int tableSize = 101;

        public MyHashSet() {
            arr = new LinkedList[101];
            for (int i = 0; i < tableSize; i++) {
                arr[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int hash = hash(key);
            Iterator<Integer> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                int val = iterator.next();
                if (key == val) {
                    return;
                }
            }
            arr[hash].offerLast(key);
        }

        public void remove(int key) {
            int hash = hash(key);
            Iterator<Integer> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) {
                    arr[hash].remove(Integer.valueOf(key));
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int hash = hash(key);
            Iterator<Integer> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) return true;
            }
            return false;
        }

        public int hash(int key) {
            return key % tableSize;
        }
    }

    public static void main(String[] args) {
        // 输入：
        //["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
        //[[], [1], [2], [1], [3], [2], [2], [2], [2]]
        //输出：
        //[null, null, null, true, false, null, true, null, false]

        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
}
