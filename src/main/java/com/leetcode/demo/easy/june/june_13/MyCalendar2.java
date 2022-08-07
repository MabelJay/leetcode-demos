package com.leetcode.demo.easy.june.june_13;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar2 {

    private TreeMap<Integer, Integer> map;

    public MyCalendar2() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry1 = map.floorEntry(start);
        Map.Entry<Integer, Integer> entry2 = map.ceilingEntry(start);

        if (entry1 != null && entry1.getValue() > start) return false;
        if (entry2 != null && entry2.getKey() < end) return false;
        map.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar2 calendar = new MyCalendar2();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}
