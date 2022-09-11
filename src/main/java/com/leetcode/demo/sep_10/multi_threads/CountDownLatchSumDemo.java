package com.leetcode.demo.sep_10.multi_threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSumDemo {

    static CountDownLatch latch = new CountDownLatch(10);
    static int sum = 0;

    private static class RunnableBody implements Runnable {
        int start;
        int end;

        public RunnableBody(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starts working");
            int tmpSum = 0;
            for (int i = start; i <= end; i++) {
                tmpSum += i;
            }
            synchronized (CountDownLatchSumDemo.class) {
                sum += tmpSum;
            }
            System.out.println(Thread.currentThread().getName() + " sum=" + sum);
            latch.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new RunnableBody(i * 10 + 1, (i + 1) * 10), "thread-" + i);
            threads[i].start();
        }
        latch.await();
        System.out.println("final result is " + sum);
    }
}
