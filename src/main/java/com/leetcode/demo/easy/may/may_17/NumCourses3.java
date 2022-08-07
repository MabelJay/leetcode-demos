package com.leetcode.demo.easy.may.may_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumCourses3 {

    List<List<Integer>> list;
    int[] visited;
    boolean isValid;
    int index;

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites2 = {{0, 1}, {1, 0}};
        System.out.println(Arrays.toString(new NumCourses3().findOrder(2, prerequisites2)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] preInfo : prerequisites) {
            list.get(preInfo[1]).add(preInfo[0]);
        }
        System.out.println(list);
        visited = new int[numCourses];
        isValid = true;
        int[] resArr = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i, resArr);
                if (!isValid) return new int[0];
            }
        }
        return resArr;
    }

    public void dfs(int u, int[] arr) {
        visited[u] = 1;
        for (int v : list.get(u)) {
            if (visited[v] == 0) {
                dfs(v, arr);
                if (!isValid) return;
            } else if (visited[v] == 1) {
                isValid = false;
                return;
            }
        }
        arr[index--] = u;
        visited[u] = 2;
    }
}
