package com.leetcode.demo.apr.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CheckIfPrerequisite {

    private static class Node {
        int val;
        int inDegree;
        List<Node> nexts;

        Node(int val) {
            this.val = val;
            this.inDegree = 0;
            this.nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
        //输出：[true,true]
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        System.out.println(new CheckIfPrerequisite().checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        if (numCourses <= 1) return list;

        Node[] courses = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Node(i);
        }

        LinkedList<Node> queue = new LinkedList<>();
        boolean[][] conditions = new boolean[numCourses][numCourses];
        for (int[] info : prerequisites) {
            courses[info[0]].nexts.add(courses[info[1]]);
            courses[info[1]].inDegree++;
            conditions[info[0]][info[1]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (courses[i].inDegree == 0) {
                queue.offer(courses[i]);
            }
        }

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (conditions[tmpNode.val][i]) {
                    for (int j = 0; j < numCourses; j++) {
                        if (conditions[j][tmpNode.val]) {
                            conditions[j][i] = true;
                        }
                    }
                    courses[i].inDegree--;
                    if (courses[i].inDegree == 0) {
                        queue.offer(courses[i]);
                    }
                }
            }
        }

        for (int[] info : queries) {
            if (conditions[info[0]][info[1]]) {
                list.add(true);
            } else list.add(false);
        }
        return list;
    }
}
