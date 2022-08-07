package com.leetcode.demo.easy.jan.jan_8;

import java.util.*;

public class PermuteUnique {

    Set<String> set = new HashSet<>();
    int offset = 0;

    boolean[] vis;

    public static void main(String[] args) {
        // 输入：nums = [1,1,2]
        //输出：
        //[[1,1,2],
        // [1,2,1],
        // [2,1,1]]

        // [2,2,1,1]
        // [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
        // [[1, 1, 2, 2], [1, 2, 1, 2], [1, 2, 2, 1], [2, 1, 1, 2], [2, 1, 2, 1], [2, 2, 1, 1]]
        int[] nums = {-1, -1, 0, 0, 1, 1, 2};
        //[-1,2,-1,2,1,-1,2,1]
        //[-1,2,0,-1,1,0,1]
        // -1,-1,0,0,1,1,2
        System.out.println(new PermuteUnique().permuteUnique(nums));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) return resList;

        List<Integer> tmpList = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(nums, resList, 0, tmpList);
        return resList;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        // int[] nums = {-1, -1, 0, 0, 1, 1, 2};
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            dfs(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
