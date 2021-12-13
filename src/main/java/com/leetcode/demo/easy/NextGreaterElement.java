package com.leetcode.demo.easy;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        //[3,1,5,7,9,2,6]
        //[1,2,3,5,6,7,9,11]
        //[5,2,6,9,11,3,7]
        int[] num1 = {3, 1, 5, 7, 9, 2, 6};
        int[] num2 = {1, 2, 3, 5, 6, 7, 9, 11};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement2(num1, num2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1];
        int index1 = 0, index2 = 0;

        for (int i = 0; i < len1; i++) {
            int temp = nums1[i];
            while (index1 < len2 && nums2[index1] != temp) {
                index1++;
            }
            if (index1 >= len2 - 1) {
                res[index2++] = -1;
            } else {
                while (index1 < len2 && nums2[index1] <= temp) {
                    index1++;
                }
                if (index1 <= len2 - 1) {
                    res[index2++] = nums2[index1];
                } else {
                    res[index2++] = -1;
                }
            }
            index1 = 0;
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int temp = nums2[i];
            while (!stack.isEmpty() && temp > stack.peek()) {
                stack.pop();
            }
            map.put(temp, stack.isEmpty() ? -1 : stack.peek());
            stack.push(temp);
        }
        for (int num : nums1) {
            res[index++] = map.get(num);
        }
        return res;
    }
}
