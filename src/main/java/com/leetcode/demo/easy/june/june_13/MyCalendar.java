package com.leetcode.demo.easy.june.june_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : list) {
            if (start < arr[1] && end > arr[0]) return false;
        }
        int[] arr = new int[]{start, end};
        list.add(arr);
        return true;
    }

    public static void main(String[] args) {
        // ["MyCalendar","book","book","book"]
        //[[],[10,20],[15,25],[20,30]]
        //输出: [null,true,false,true]

        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}