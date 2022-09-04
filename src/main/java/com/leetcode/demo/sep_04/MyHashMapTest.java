package com.leetcode.demo.sep_04;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "23");
        map.put(2, "22");
        System.out.println(map.size);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
