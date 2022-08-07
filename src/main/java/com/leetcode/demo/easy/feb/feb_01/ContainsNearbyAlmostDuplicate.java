package com.leetcode.demo.easy.feb.feb_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1], k = 3, t = 0
        //输出：true

        // 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
        //输出：false

        // [1,2,2,3,4,5]
        //3

        int[] nums = {1, 2, 3, 1};
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;
        if (k <= 0) return false;
        int len = nums.length;
        long w = (long) t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    public long getId(long x, long w) {
        if (x >= 0) return x / w;
        return (x + 1) / w - 1;
    }
}
