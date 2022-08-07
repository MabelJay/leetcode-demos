package com.leetcode.demo.easy.apr.apr_30_2;

import java.util.*;
import java.util.stream.Collectors;

public class FindClosestElements {

    public static void main(String[] args) {
        // 输入：arr = [1,2,3,4,5], k = 4, x = 3
        //输出：[1,2,3,4]

        // 输入：arr = [1,2,3,4,5], k = 4, x = -1
        //输出：[1,2,3,4]

        // arr = [1,2,5,7,9], k = 4, x = 3

        int[] arr = {1, 2, 3, 4, 5};

        // [1,1,1,10,10,10]
        //1
        //9

        // [0,0,1,2,3,3,4,7,7,8]
        //3
        //5
        System.out.println(new FindClosestElements().findClosestElements(arr, 4, 3));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (x < arr[0]) {
            return list.subList(0, k);
        } else if (x > arr[len - 1]) {
            return list.subList(len - k, len);
        } else {
            int index = 0;
            while (index < len - 1) {
                if (arr[index] <= x && arr[index + 1] > x) break;
                index++;
            }
            int left = index;
            int right = index + 1;
            int count = 0;
            while (left >= 0 || right < len) {
                if (count == k) break;
                if (left < 0) {
                    right++;
                } else if (right >= len) {
                    left--;
                } else {
                    if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                        left--;
                    } else right++;
                }
                count++;
            }
            list = list.subList(left + 1, right);
            return list;
        }
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list, (o1, o2) -> o1 == o2 ? o1 - o2 : Math.abs(o1 - x) - Math.abs(o2 - x));
        list = list.subList(0, k);
        Collections.sort(list);
        return list;
    }
}
