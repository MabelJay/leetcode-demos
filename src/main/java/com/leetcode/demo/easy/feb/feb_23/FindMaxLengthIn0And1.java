package com.leetcode.demo.easy.feb.feb_23;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLengthIn0And1 {

    public static void main(String[] args) {
        // 输入: nums = [0,1,0]
        //输出: 2

        int[] nums = {0, 1, 0};
        System.out.println(new FindMaxLengthIn0And1().findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                counter--;
            } else counter++;

            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLen = Math.max(maxLen, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLen;
    }
}
