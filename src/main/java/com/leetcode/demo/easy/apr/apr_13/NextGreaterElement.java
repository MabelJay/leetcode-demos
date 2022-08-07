package com.leetcode.demo.easy.apr.apr_13;

import com.leetcode.demo.easy.feb.feb_20.NextGreaterElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement {

    public static void main(String[] args) {
        // 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
        //输出：[-1,3,-1]

        // 输入：nums1 = [2,4], nums2 = [1,2,3,4].
        //输出：[3,-1]

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        // 输入：nums1 = [2,4], nums2 = [1,2,3,4].
        //输出：[3,-1]
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement2(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int j = 0; j < nums1.length; j++) {
            int index = map.get(nums1[j]);
            for (int i = index + 1; i < nums2.length; i++) {
                if (nums2[i] > nums2[index]) {
                    res[j] = nums2[i];
                    break;
                }
            }
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len2; i++) {
            int temp = nums2[i];
            while (!stack.isEmpty() && temp > stack.peek()) {
                map.put(stack.pop(), temp);
            }
            stack.push(temp);
        }
        for (int i = 0; i < len1; i++) {
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return res;
    }
    // int[] res = new int[nums1.length];
    //        int index = 0;
    //        Map<Integer, Integer> map = new HashMap<>();
    //        Deque<Integer> stack = new LinkedList<>();
    //        for (int i = nums2.length - 1; i >= 0; i--) {
    //            int temp = nums2[i];
    //            while (!stack.isEmpty() && temp > stack.peek()) {
    //                stack.pop();
    //            }
    //            map.put(temp, stack.isEmpty() ? -1 : stack.peek());
    //            stack.push(temp);
    //        }
    //        for (int num : nums1) {
    //            res[index++] = map.get(num);
    //        }
    //        return res;
}
