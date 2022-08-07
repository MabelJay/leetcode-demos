package com.leetcode.demo.easy.may.may_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinish {

    List<List<Integer>> list;
    int[] visited;
    boolean isValid;

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        //输出：true

        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {2, 0}, {0,1}};
        System.out.println(new CanFinish().canFinish2(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            list.get(info[1]).add(info[0]);
        }

        visited = new int[numCourses];
        isValid = true;

        for (int i = 0; i < numCourses && isValid; i++) {
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

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] info : prerequisites) {
            list.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            index++;
            for (int node : list.get(val)) {
                inDegree[node]--;
                if (inDegree[node] == 0) queue.offer(node);
            }
        }
        return index == numCourses;
    }
}
