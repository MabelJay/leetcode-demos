package com.leetcode.demo.easy.may.may_25_1;

public class MultiThreadsCount {

    static int sum;

    static class SumRunnable implements Runnable {
        int start;
        int end;

        public SumRunnable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sum = 0;
        for (int i = 0; i < 10; i++) {
            new Thread(new SumRunnable(i * 10 + 1, i * 10 + 10)).start();
        }
        Thread.sleep(1000L);
        System.out.println(sum);
    }
}
