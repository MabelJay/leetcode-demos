package com.leetcode.demo.easy.feb.feb_20;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElements {

    public static void main(String[] args) {
        // 输入: nums = [1,2,1]
        //输出: [2,-1,2]

        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(new NextGreaterElements().nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] resArr = new int[len];

        Arrays.fill(resArr, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                resArr[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return resArr;
    }
}
