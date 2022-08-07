package com.leetcode.demo.easy.feb.feb_01;

import java.util.*;

public class FindOrder {

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    int[] res;
    int index;

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        //输出：[0,1]

        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new FindOrder().findOrder(4, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        res = new int[numCourses];
        index = numCourses - 1;
        Arrays.fill(res, -1);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) return new int[0];
        return res;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        res[index--] = u;
        visited[u] = 2;
    }
}
