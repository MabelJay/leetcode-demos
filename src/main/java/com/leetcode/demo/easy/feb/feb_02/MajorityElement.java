package com.leetcode.demo.easy.feb.feb_02;

import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {
        // 输入：[1,1,1,3,3,2,2,2]
        //输出：[1,2]
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(new MajorityElement().majorityElement3(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int targetNum = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > targetNum && !res.contains(num)) res.add(num);
        }
        return res;
    }

    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length / 3;
        Arrays.sort(nums);

        int count = 1;
        int index = 0;
        while (index < nums.length) {
            while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
                count++;
                index++;
            }

            if (count > len) res.add(nums[index]);
            count = 1;
            index++;
        }
        return res;
    }

    public List<Integer> majorityElement3(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                vote1++;
            } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                vote2++;
            } else if (vote1 == 0) { // 选择第一个元素
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // 选择第二个元素
                element2 = num;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }
}
