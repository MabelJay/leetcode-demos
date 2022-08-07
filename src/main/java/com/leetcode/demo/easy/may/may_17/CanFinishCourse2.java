package com.leetcode.demo.easy.may.may_17;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinishCourse2 {
    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int[][] prerequisites = {{1, 0}};
        System.out.println(new CanFinishCourse2().canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] preInfos : prerequisites) {
            edges.get(preInfos[1]).add(preInfos[0]);
            indegree[preInfos[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : edges.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return count == numCourses;
    }
}
