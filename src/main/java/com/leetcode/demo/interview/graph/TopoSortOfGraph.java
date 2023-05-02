package com.leetcode.demo.interview.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopoSortOfGraph {

    private static class Node {
        int val;
        int inDegree;
        List<Node> nexts;

        Node(int val) {
            this.val = val;
            inDegree = 0;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] info : prerequisites) {
            nodes[info[1]].nexts.add(nodes[info[0]]);
            nodes[info[0]].inDegree++;
        }
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nodes[i].inDegree == 0) queue.offer(nodes[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            count++;
            for (Node next : tmpNode.nexts) {
                next.inDegree--;
                if (next.inDegree == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
