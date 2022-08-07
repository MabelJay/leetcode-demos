package com.leetcode.demo.easy.feb.feb_02;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {
        // 输入: k = 3, n = 7
        //输出: [[1,2,4]]

        // 输入: k = 3, n = 9
        //输出: [[1,2,6], [1,3,5], [2,3,4]]

        // 9
        //45

        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), res, k, n, 1);
        return res;
    }

    public void dfs(List<Integer> combine, List<List<Integer>> list, int k, int n, int index) {
        if (index > 10 || index <= 0) return;
        if (n == 0) {
            if (combine.size() == k) {
                list.add(new ArrayList<>(combine));
            }
            return;
        }

        dfs(combine, list, k, n, index + 1);
        if (index <= n) {
            combine.add(index);
            dfs(combine, list, k, n - index, index + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
