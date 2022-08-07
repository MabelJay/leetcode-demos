package com.leetcode.demo.easy.jan.jan_28;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        // 输入：nums = [3,30,34,5,9]
        //输出："9534330"

        String s = "34";
        String s2 = "9";

        int[] nums = {0, 0};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber2(int[] nums) {
        if (nums.length == 0) return String.valueOf(nums[0]);
        int len = nums.length;

        for (int j = 1; j < len; j++) {
            int temp = nums[j];
            int i = j - 1;

            while (i >= 0 && !concatStr(nums[i], temp)) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == 0 && nums[0] == 0) return "0";
            sb.append(nums[i]);
        }

        return sb.toString();
    }

    public boolean concatStr(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }

    public boolean concatStr(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;

        String[] strArr = new String[len];
        for (int i = 0; i < len; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        System.out.println(Arrays.toString(strArr));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (i == 0 && strArr[0].equals("0")) return "0";
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
