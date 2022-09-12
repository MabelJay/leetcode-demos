package com.leetcode.demo.sep_12;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        // 输入：n = 4, k = 2
        //输出：
        //[
        //  [2,4],
        //  [3,4],
        //  [2,3],
        //  [1,2],
        //  [1,3],
        //  [1,4],
        //]

        System.out.println(new Combine().combine(4, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (n < 1 || k > n) return list;

        dfs(list, new ArrayList<>(), 1, n, k);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> combine, int cur, int n, int k) {
        if (combine.size() + (n - cur + 1) < k) return;
        if (combine.size() == k) {
            list.add(new ArrayList<>(combine));
            return;
        }

        combine.add(cur);
        dfs(list, combine, cur + 1, n, k);
        combine.remove(combine.size() - 1);
        dfs(list, combine, cur + 1, n, k);
    }
}
