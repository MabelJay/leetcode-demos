package com.leetcode.demo.nov.day23;

import java.util.*;

public class CourseCanFinish2 {

    private static class Node {
        int val;
        int in;
        int out;

        List<Node> nodes;

        public Node(int val) {
            this.val = val;
            in = 0;
            out = 0;
            nodes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(new CourseCanFinish2().canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;

        Node[] nodeArr = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int[] row : prerequisites) {
            nodeArr[row[1]].nodes.add(nodeArr[row[0]]);
            nodeArr[row[0]].in++;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nodeArr[i].in == 0) {
                queue.offer(nodeArr[i]);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            count++;

            for (Node next : cur.nodes) {
                next.in--;
                if (next.in == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }
}
