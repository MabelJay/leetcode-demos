package com.leetcode.demo.easy.feb.feb_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindOrder2 {

    List<List<Integer>> edges;
    int[] inDegree;
    int[] res;
    int index;

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new FindOrder2().findOrder(4, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        index = 0;
        res = new int[numCourses];
        inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res[index++] = temp;
            for (int v : edges.get(temp)) {
                --inDegree[v];
                if (inDegree[v] == 0) queue.offer(v);
            }
        }
        if (index != numCourses) return new int[0];
        return res;
    }
}
