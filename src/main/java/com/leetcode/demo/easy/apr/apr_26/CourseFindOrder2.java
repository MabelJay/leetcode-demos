package com.leetcode.demo.easy.apr.apr_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseFindOrder2 {

    List<List<Integer>> edges;
    int[] inDegree;
    int index;
    int[] result;

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new CourseFindOrder2().findOrder(4, prerequisites)));
    }

    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }
        result = new int[numCourses];
        index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            result[index++] = temp;
            for (int node : edges.get(temp)) {
                inDegree[node]--;
                if (inDegree[node] == 0) queue.offer(node);
            }
        }
        if (index != numCourses) return new int[0];
        return result;
    }
}
