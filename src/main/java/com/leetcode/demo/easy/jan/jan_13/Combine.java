package com.leetcode.demo.easy.jan.jan_13;

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

        System.out.println(new Combine().combine(4, 1));
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        dfs(arr, new ArrayList<>(), resList, 0, k);
        return resList;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

        dfs2(1, 4, 2, tmpList, resList);
        return resList;
    }

    public void dfs(int[] arr, List<Integer> combine, List<List<Integer>> resList, int index, int k) {

        if (combine.size() == k) {
            resList.add(new ArrayList<>(combine));
            return;
        }

        if (index == arr.length) return;

        for (int i = index; i < arr.length; i++) {
            combine.add(arr[i]);
            dfs(arr, combine, resList, i + 1, k);
            combine.remove(combine.size() - 1);
        }
    }

    public void dfs2(int cur, int n, int k, List<Integer> tmpList, List<List<Integer>> resList) {
        if (tmpList.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (tmpList.size() == k) {
            resList.add(new ArrayList<>(tmpList));
            return;
        }
        // 考虑选择当前位置
        tmpList.add(cur);
        dfs2(cur + 1, n, k, tmpList, resList);
        tmpList.remove(tmpList.size() - 1);
        // 考虑不选择当前位置
        dfs2(cur + 1, n, k, tmpList, resList);
    }
}
