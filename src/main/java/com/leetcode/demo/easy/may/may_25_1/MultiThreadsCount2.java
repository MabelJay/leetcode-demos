package com.leetcode.demo.easy.may.may_25_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadsCount2 {

    static class CountCallable implements Callable<Integer> {
        private CyclicBarrier barrier;
        private Integer initValue;
        public CountCallable(CyclicBarrier barrier, Integer initValue) {
            this.barrier = barrier;
            this.initValue = initValue;
        }
        @Override
        public Integer call() throws Exception {
            this.barrier.await();
            return sum();
        }
        public int sum() {
            int sum = 0;
            for (int i = initValue; i < initValue + 10; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CountCallable callable = new CountCallable(cyclicBarrier, i * 10 + 1);
            Future<Integer> result = executorService.submit(callable);
            resList.add(result);
        }
//        System.out.println("submit success");
        int totalSum = 0;
        for (Future<Integer> future : resList) {
            totalSum += future.get();
        }
        System.out.println("total sum = " + totalSum);
        executorService.shutdown();
    }
}
