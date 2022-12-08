package com.leetcode.demo.nov.day23;

import java.util.*;

public class CourseCanFinish {
    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        //输出：true

        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int[][] prerequisites = {{1, 0}};
        System.out.println(new CourseCanFinish().canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites.length == 0) return true;

        int[] inDegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            count++;
            List<Integer> tmpList = edges.get(curNode);
            for (int node : tmpList) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        return count == numCourses;
    }
}
