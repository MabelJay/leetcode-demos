package com.leetcode.demo.easy.apr.apr_14;

import com.leetcode.demo.easy.feb.feb_01.ContainsNearbyAlmostDuplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1], k = 3
        // 1 1 2 3
        //输出：true

        //输入：nums = [1,0,1,1], k = 1
        //输出：true

        int[] nums = {1,0,1,1};
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, 1));

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) return k <= 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    // Set<Integer> set = new HashSet<>();
    //        for (int i = 0; i < nums.length; ++i) {
    //            if (set.contains(nums[i])) return true;
    //            set.add(nums[i]);
    //            if (set.size() > k) {
    //                set.remove(nums[i - k]);
    //            }
    //        }
    //        return false;
}
