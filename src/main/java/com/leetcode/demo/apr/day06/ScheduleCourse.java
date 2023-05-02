package com.leetcode.demo.apr.day06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleCourse {

    public static void main(String[] args) {
        // 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
        //输出：3

        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(new ScheduleCourse().scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) return 0;
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int total = 0;
        for (int[] course : courses) {
            int t = course[0];
            int d = course[1];
            if (total + t <= d) {
                total += t;
                queue.offer(t);
            } else if (!queue.isEmpty() && queue.peek() > t) {
                total -= queue.poll() - t;
                queue.offer(t);
            }
        }
        return queue.size();
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
