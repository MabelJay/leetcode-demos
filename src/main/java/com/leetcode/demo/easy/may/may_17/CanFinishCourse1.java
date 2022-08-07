package com.leetcode.demo.easy.may.may_17;

import com.leetcode.demo.easy.jan.jan_30.CanFinishCourse;

import java.util.ArrayList;
import java.util.List;

public class CanFinishCourse1 {

    List<List<Integer>> list;
    int[] visited;
    boolean isValid;

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int[][] prerequisites = {{1, 0}};
        System.out.println(new CanFinishCourse1().canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        isValid = true;
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] preInfo : prerequisites) {
            list.get(preInfo[1]).add(preInfo[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
                if (!isValid) return false;
            }
        }
        return true;
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
        visited[u] = 2;
    }
}
