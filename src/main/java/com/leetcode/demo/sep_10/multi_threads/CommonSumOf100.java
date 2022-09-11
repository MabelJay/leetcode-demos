package com.leetcode.demo.sep_10.multi_threads;

public class CommonSumOf100 {

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
            int tempSum = 0;
            for (int i = start; i <= end; i++) {
                tempSum += i;
            }

            synchronized (CommonSumOf100.class) {
                sum += tempSum;
                System.out.println(Thread.currentThread().getName() + " is done, sum=" + sum);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new RunnableBody(i * 10 + 1, (i + 1) * 10), "thread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(Thread.currentThread().getName() + " is working, final sum=" + sum);
        System.out.println("total time is: "+(System.currentTimeMillis() - startTime));
    }
}
