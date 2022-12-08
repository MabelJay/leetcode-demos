package com.leetcode.demo.dec.day04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinishCourse1 {

    private static class Node {
        int val;
        int in;
        List<Node> nexts;

        public Node(int val) {
            this.val = val;
            in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(new CanFinishCourse1().canFinish2(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return true;
        List<List<Integer>> edges = new ArrayList<>();
        int[] inDegree = new int[numCourses];
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
        int count = 0;
        while (!queue.isEmpty()) {
            int tmpNode = queue.poll();
            count++;
            for (int next : edges.get(tmpNode)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return true;
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
