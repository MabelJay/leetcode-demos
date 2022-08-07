package com.leetcode.demo.easy;

public class FindMaxAverage {

    public static void main(String[] args) {
        //输入：nums = [1,12,-5,-6,50,3], k = 4
        //输出：12.75

        //[0,1,1,3,3]
        //4

        //[8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891]
        //93

        int[] nums = {8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        int k = 4;

        int[] nums1 = {1, 12, -5, -6, 50, 3};
        System.out.println(new FindMaxAverage().findMaxAverage3(nums, 93));
    }

    public double findMaxAverage2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        double maxNum = Integer.MIN_VALUE;
        int index = 0;
        while (index < nums.length - k + 1) {
            int thisSum = 0;
            for (int i = 0; i < k; i++) {
                thisSum += nums[index + i];
            }
            maxNum = Math.max(maxNum, thisSum);
            index++;
        }
        return maxNum / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] resArr = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            resArr[0] += nums[i];
        }
        double maxNum = resArr[0];
        for (int i = 1; i < resArr.length; i++) {
            resArr[i] = resArr[i - 1] + nums[i + k - 1] - nums[i - 1];
            maxNum = Math.max(resArr[i], maxNum);
        }
        return maxNum / k;
    }

    public double findMaxAverage3(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
