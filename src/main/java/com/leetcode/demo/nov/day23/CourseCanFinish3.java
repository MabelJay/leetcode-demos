package com.leetcode.demo.nov.day23;

import java.util.*;

public class CourseCanFinish3 {

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]

        int[][] prerequisites = {};
        System.out.println(Arrays.toString(new CourseCanFinish3().findOrder(1, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return new int[0];

        List<List<Integer>> nodeList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nodeList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] row : prerequisites) {
            nodeList.get(row[1]).add(row[0]);
            inDegree[row[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        System.out.println(queue);
        int count = 0;
        int[] resArr = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            resArr[count++] = cur;
            for (int next : nodeList.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses ? resArr : new int[0];
    }
}
