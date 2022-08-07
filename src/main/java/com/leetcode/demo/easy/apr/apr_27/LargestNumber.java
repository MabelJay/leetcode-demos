package com.leetcode.demo.easy.apr.apr_27;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        // 输入：nums = [3,30,34,5,9]
        //输出："9534330"

        // 输入：nums = [10,2]
        //输出："210"

        int[] nums = {10,2};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) return "0";
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
