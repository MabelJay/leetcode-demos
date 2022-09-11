package com.leetcode.demo.sep_10.multi_threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSumOf100 {

    static int sum = 0;

    private static class RunnableBody implements Callable<Integer> {
        int start;
        int end;

        public RunnableBody(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int tmpSum = 0;
            for (int i = start; i <= end; i++) {
                tmpSum += i;
            }

            synchronized (ExecutorSumOf100.class) {
                sum += tmpSum;
                System.out.println(Thread.currentThread().getName() + " is done, sum=" + sum);
                return sum;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = service.submit(new RunnableBody(i * 10 + 1, (i + 1) * 10));
            System.out.println("res=" + future.get());
        }
        service.shutdown();
        System.out.println(Thread.currentThread().getName() + " is working, sum = " + sum);
        System.out.println("total time is: " + (System.currentTimeMillis() - startTime));
    }
}
