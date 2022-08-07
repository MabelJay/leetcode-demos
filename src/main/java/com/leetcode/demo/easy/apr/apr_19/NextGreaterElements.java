package com.leetcode.demo.easy.apr.apr_19;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElements {

    public static void main(String[] args) {
        // 输入: nums = [1,2,1]
        //输出: [2,-1,2]

        // 输入: nums = [1,2,3,4,3]
        //输出: [2,3,4,-1,4]

        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(new NextGreaterElements().nextGreaterElements2(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;
        int index = 0;
        while (count < 2) {
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
            index++;
            if (index == n) {
                index = 0;
                count++;
            }
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            int curIndex = i % n;
            while (!stack.isEmpty() && nums[curIndex] > nums[stack.peek()]) {
                res[stack.pop()] = nums[curIndex];
            }
            stack.push(curIndex);
        }
        return res;
    }

    //  int len = nums.length;
    //            int[] resArr = new int[len];
    //
    //            Arrays.fill(resArr, -1);
    //            LinkedList<Integer> stack = new LinkedList<>();
    //            for (int i = 0; i < 2 * len - 1; i++) {
    //                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
    //                    resArr[stack.pop()] = nums[i % len];
    //                }
    //                stack.push(i % len);
    //            }
    //            return resArr;
}
