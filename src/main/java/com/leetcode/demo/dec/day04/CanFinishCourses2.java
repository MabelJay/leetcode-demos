package com.leetcode.demo.dec.day04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinishCourses2 {

    private static class Node {
        int val;
        int in;
        List<Node> next;

        public Node(int val) {
            this.val = val;
            in = 0;
            next = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        int[] res = new int[numCourses];

        List<List<Integer>> edges = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegrees[info[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int tmpNode = queue.poll();
            res[count++] = tmpNode;

            for (int next : edges.get(tmpNode)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses ? res : new int[0];
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        int[] res = new int[numCourses];
        Node[] edges = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new Node(i);
        }

        for (int[] info : prerequisites) {
            edges[info[1]].next.add(edges[info[0]]);
            edges[info[0]].in++;
        }

        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i].in == 0) queue.offer(edges[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            res[count++] = tmpNode.val;
            for (Node next : tmpNode.next) {
                next.in--;
                if (next.in == 0) queue.offer(next);
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
