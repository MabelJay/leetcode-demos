package com.leetcode.demo.easy.jan.jan_7;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
        //[1,1,6],
        //[1,2,5],
        //[1,7],
        //[2,6]

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombinationSum2().combinationSum2(candidates, target));
    }

    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        System.out.println(Arrays.toString(candidates));
        for (int num : candidates) {
            if (freq.isEmpty() || num != freq.get(freq.size() - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
