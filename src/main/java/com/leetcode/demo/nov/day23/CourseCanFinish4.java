package com.leetcode.demo.nov.day23;

import java.util.*;

public class CourseCanFinish4 {

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
        // ：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //输出：[0,2,1,3]

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new CourseCanFinish4().findOrder(4, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return new int[0];

        Node[] nodeArr = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int[] info : prerequisites) {
            nodeArr[info[1]].nexts.add(nodeArr[info[0]]);
            nodeArr[info[0]].in++;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nodeArr[i].in == 0) {
                queue.offer(nodeArr[i]);
            }
        }

        int index = 0;
        int[] resArr = new int[numCourses];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            resArr[index++] = cur.val;
            for (Node next : cur.nexts) {
                next.in--;
                if (next.in == 0) queue.offer(next);
            }
        }
        return index == numCourses ? resArr : new int[0];
    }
}
