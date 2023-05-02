package com.leetcode.demo.apr.day04.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinishCourse1 {

    private static class Node {
        int val;
        List<Node> nexts;
        int in;

        Node(int val) {
            this.val = val;
            this.in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false

        int[][] prerequisites = {{1, 0}, {0, 1}};
        int numCourses = 2;

        System.out.println(new CanFinishCourse1().canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] info : prerequisites) {
            nodes[info[1]].nexts.add(nodes[info[0]]);
            nodes[info[0]].in++;
        }

        int count = 0;
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nodes[i].in == 0) queue.offer(nodes[i]);
        }

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            count++;
            for (Node next : tmpNode.nexts) {
                next.in--;
                if (next.in == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
