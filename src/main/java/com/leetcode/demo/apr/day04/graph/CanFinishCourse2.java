package com.leetcode.demo.apr.day04.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CanFinishCourse2 {

    private static class Node {
        int val;
        int in;
        List<Node> nexts;

        Node(int val) {
            this.val = val;
            this.in = 0;
            this.nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] pre2 = {};
        System.out.println(Arrays.toString(new CanFinishCourse2().findOrder(1, pre2)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] info : prerequisites) {
            nodes[info[1]].nexts.add(nodes[info[0]]);
            nodes[info[0]].in++;
        }

        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nodes[i].in == 0) queue.offer(nodes[i]);
        }

        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            res[count++] = tmpNode.val;

            for (Node next : tmpNode.nexts) {
                next.in--;
                if (next.in == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
