package com.leetcode.demo.easy.apr.apr_26;

import java.util.ArrayList;
import java.util.List;

public class CourseCanFinish {

    List<List<Integer>> edges;
    boolean isValid;
    int[] visited;

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        //输出：true
        //解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new CourseCanFinish().canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        isValid = true;
        for (int i = 0; i < numCourses && isValid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return isValid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!isValid) return;
            } else if (visited[v] == 1) {
                isValid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
