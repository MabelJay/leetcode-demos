package com.leetcode.demo.easy.mar.mar_25;

import java.util.Arrays;

public class PartitionDisjoint {

    public static void main(String[] args) {
        // 输入：nums = [5,0,3,8,6]
        //输出：3
        //解释：left = [5,0,3]，right = [8,6]

        int[] nums = {5, 0, 3, 8, 6};

        // [6,0,8,30,37,6,75,98,39,90,63,74,52,92,64]
        // 2
        int[] num2 = {6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64};

        // [29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88]
        //11

        // [26,51,40,58,42,76,30,48,79,91]
        // 1
        int[] nums3 = {29, 33, 6, 4, 42, 0, 10, 22, 62, 16, 46, 75, 100, 67, 70, 74, 87, 69, 73, 88};

        int[] num4 = {26, 51, 40, 58, 42, 76, 30, 48, 79, 91};
     /*   System.out.println(new PartitionDisjoint().partitionDisjoint(nums));
        System.out.println(new PartitionDisjoint().partitionDisjoint(num2));
        System.out.println(new PartitionDisjoint().partitionDisjoint(nums3));*/

        System.out.println(new PartitionDisjoint().partitionDisjoint(num4));
        System.out.println(new PartitionDisjoint().partitionDisjoint2(num4));
    }

    public int partitionDisjoint(int[] nums) {
        if (nums.length < 3) return 1;
        int len = nums.length;

        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < min) {
                indexMin = i;
                min = nums[i];
            }
        }

        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < indexMin; i++) {
            maxLeft = Math.max(nums[i], maxLeft);
        }

        int targetIndex = indexMin;
        for (int i = len - 1; i > indexMin; i--) {
            if (nums[i] < maxLeft) {
                targetIndex = i;
                break;
            }
        }
        for (int i = indexMin + 1; i <= targetIndex; i++) {
            maxLeft = Math.max(nums[i], maxLeft);
        }

        int count = 0;
        int index = len - 1;
        while (index > targetIndex && nums[index] >= maxLeft) {
            count++;
            index--;
        }
        return len - count;
    }

    public int partitionDisjoint2(int[] nums) {
        if (nums.length == 2) return 1;
        int len = nums.length;
        int[] maxFromLeft = new int[len];
        int[] minFromRight = new int[len];
        maxFromLeft[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            maxFromLeft[i] = max;
        }

        max = nums[len - 1];
        minFromRight[len - 1] = max;
        for (int i = len - 2; i >= 0; i--) {
            max = Math.min(max, nums[i]);
            minFromRight[i] = max;
        }
        for (int i = 1; i < len; i++) {
            if (maxFromLeft[i-1] <= minFromRight[i]) return i;
        }
        return -1;
    }
}
