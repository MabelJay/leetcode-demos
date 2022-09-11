package com.leetcode.demo.sep_10.multi_threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    static int sum = 0;
    static CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println("sum=" + sum));

    private static class RunnableBody implements Runnable {
        int start;
        int end;

        public RunnableBody(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int tmpSum = 0;
            for (int i = start; i <= end; i++) {
                tmpSum += i;
            }
            synchronized (CyclicBarrierDemo.class) {
                sum += tmpSum;
            }
            System.out.println(Thread.currentThread().getName() + " is done, sum=" + sum);
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(new RunnableBody(i * 10 + 1, (i + 1) * 10));
        }
        service.shutdown();
    }
}
