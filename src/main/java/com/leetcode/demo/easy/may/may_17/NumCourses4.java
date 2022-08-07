package com.leetcode.demo.easy.may.may_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumCourses4 {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(new NumCourses4().findOrder(2, prerequisites2)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] preInfo : prerequisites) {
            list.get(preInfo[1]).add(preInfo[0]);
            inDegree[preInfo[0]]++;
        }
        int[] resArr = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            resArr[count] = u;
            count++;
            for (int v : list.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) queue.offer(v);
            }
        }
        return count == numCourses ? resArr : new int[0];
    }
}
