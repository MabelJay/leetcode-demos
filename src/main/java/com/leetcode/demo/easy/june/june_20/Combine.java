package com.leetcode.demo.easy.june.june_20;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        // 输入: n = 4, k = 2
        //输出:
        //[
        //  [2,4],
        //  [3,4],
        //  [2,3],
        //  [1,2],
        //  [1,3],
        //  [1,4],
        //]

        System.out.println(new Combine().combine2(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), list, 1);
        return list;
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs2(n, k, list, new ArrayList<>(), 1);
        return list;
    }

    public void dfs2(int n, int k, List<List<Integer>> list, List<Integer> combine, int cur) {
        if (combine.size() + (n - cur + 1) < k) return;
        if (combine.size() == k) {
            list.add(new ArrayList<>(combine));
            return;
        }

        combine.add(cur);
        dfs2(n, k, list, combine, cur + 1);
        combine.remove(combine.size() - 1);
        dfs2(n, k, list, combine, cur + 1);
    }

    public void dfs(int n, int k, List<Integer> combine, List<List<Integer>> list, int cur) {
        if (combine.size() == k) {
            list.add(new ArrayList<>(combine));
            return;
        }
        if (cur > n) return;

        for (int i = cur; i <= n; i++) {
            combine.add(i);
            dfs(n, k, combine, list, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
