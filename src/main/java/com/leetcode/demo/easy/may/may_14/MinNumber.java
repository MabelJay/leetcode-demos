package com.leetcode.demo.easy.may.may_14;

import java.util.Arrays;

public class MinNumber {

    public static void main(String[] args) {
        // 输入: [10,2]
        //输出: "102"

        // 输入: [3,30,34,5,9]
        //输出: "3033459"

        int[] nums = {10,2};
        System.out.println(new MinNumber().minNumber(nums));
    }

    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "" + nums[i];
        }
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
