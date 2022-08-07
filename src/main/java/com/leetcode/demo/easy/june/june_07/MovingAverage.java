package com.leetcode.demo.easy.june.june_07;

import java.util.LinkedList;

class MovingAverage {

    LinkedList<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        sum += val;
        if (queue.size() >= size) {
            sum -= queue.poll();
            queue.offer(val);
            return sum / size;
        } else {
            queue.offer(val);
            return sum / queue.size();
        }
    }

    public static void main(String[] args) {
        // inputs = ["MovingAverage", "next", "next", "next", "next"]
        //inputs = [[3], [1], [10], [3], [5]]
        //输出：
        //[null, 1.0, 5.5, 4.66667, 6.0]

        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }
}