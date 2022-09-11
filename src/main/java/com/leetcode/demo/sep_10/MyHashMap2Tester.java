package com.leetcode.demo.sep_10;

public class MyHashMap2Tester {

    public static void main(String[] args) {
        MyHashMap2<Integer, String> map = new MyHashMap2<>();
        map.put(1, "hello java");
        map.put(2, "hello c");
        map.put(3, "123");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.size());
    }
}
