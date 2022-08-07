package com.leetcode.demo.easy;

import java.util.*;

public class FindRestaurant {

    public static void main(String[] args) {
        //输入:
        //["Shogun", "Tapioca Express", "Burger King", "KFC"]
        //["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
        //输出: ["Shogun"]

        // ["Shogun","Tapioca Express","Burger King","KFC"]
        //["KFC","Shogun","Burger King"]

        //["S","TEXP","BK","KFC"]
        //["KFC","BK","S"]
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(new FindRestaurant().findRestaurant2(list1, list2)));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int count = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = 0;
        String[] res = new String[Math.min(list1.length, list2.length)];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String temp = list2[i];
            if (map.containsKey(temp)) {
                int val = map.get(temp) + i;
                if (val <= count) {
                    if (val < count) {
                        count = val;
                        index1 = index2;
                    }
                    res[index2++] = temp;
                }
            }
        }
       /* System.out.println(Arrays.toString(res));
        System.out.println("index1=" + index1 + " index2=" + index2);*/
        return Arrays.copyOfRange(res, index1, index2);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for (int i = 0; i <= sum; i++) {
                if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i]))
                    res.add(list1[i]);
            }
            if (res.size() > 0)
                break;
        }
        return res.toArray(new String[res.size()]);
    }

    public String[] findRestaurant3(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
