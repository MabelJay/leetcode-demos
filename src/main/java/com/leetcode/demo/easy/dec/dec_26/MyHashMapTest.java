package com.leetcode.demo.easy.dec.dec_26;

public class MyHashMapTest {

    public static void main(String[] args) {
        //["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
        //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
        //输出：
        //[null, null, null, 1, -1, null, 1, null, -1]

        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.put(2, 1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
