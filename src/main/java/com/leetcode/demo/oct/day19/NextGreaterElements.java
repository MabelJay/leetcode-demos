package com.leetcode.demo.oct.day19;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElements {

    public static void main(String[] args) {
        // 输入: nums = [1,2,1]
        //输出: [2,-1,2]

        // 输入: nums = [1,2,3,4,3]
        //输出: [2,3,4,-1,4]

        int[] nums = {1, 2, 3, 4, 3};
        new NextGreaterElements().nextGreaterElements(nums);
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        int len = nums.length;
        int[] resArr = new int[len];
        Arrays.fill(resArr, -1);
        while (index < 2 * len - 1) {
            int i = index % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                resArr[stack.pop()] = nums[i];
            }
            stack.push(i);
            index++;
        }
//        System.out.println(Arrays.toString(resArr));
        return resArr;
    }
}
