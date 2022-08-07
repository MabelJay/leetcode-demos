package com.leetcode.demo.easy.apr.apr_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseFindOrder {

    List<List<Integer>> list;
    int[] visited;
    boolean isValid;
    int[] result;
    int index;

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new CourseFindOrder().findOrder(4, prerequisites)));
    }

    //DFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            list.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        isValid = true;
        result = new int[numCourses];
        index = numCourses - 1;

        for (int i = 0; i < numCourses && isValid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!isValid) return new int[0];
        return result;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : list.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!isValid) return;
            } else if (visited[v] == 1) {
                isValid = false;
                return;
            }
        }
        result[index--] = u;
        visited[u] = 2;
    }
}
