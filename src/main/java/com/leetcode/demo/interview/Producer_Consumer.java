package com.leetcode.demo.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Producer_Consumer {

    private static final int MAX_AMOUNT = 10;

    static class DataBuffer<T> {
        private List<T> dataList = new LinkedList<>();
        private Integer amount = 0;

        private final Object LOCK_OBJECT = new Object();
        private final Object NOT_FULL = new Object();
        private final Object NOT_EMPTY = new Object();

        public void add(T element) throws Exception {
            while (amount > MAX_AMOUNT) {
                synchronized (NOT_FULL) {
                    System.out.println("queue is full");
                    NOT_FULL.wait();
                }
            }
            synchronized (LOCK_OBJECT) {
                dataList.add(element);
                amount++;
            }
            synchronized (NOT_EMPTY) {
                NOT_EMPTY.notify();
            }
        }

        public T fetch() throws Exception {
            while (amount <= 0) {
                synchronized (NOT_EMPTY) {
                    System.out.println("queue is empty");
                    NOT_EMPTY.wait();
                }
            }

            T element = null;
            synchronized (LOCK_OBJECT) {
                element = dataList.remove(0);
                amount--;
            }

            synchronized (NOT_FULL) {
                NOT_FULL.notify();
            }
            return element;
        }
    }

    public static void main(String[] args) throws Exception {
        DataBuffer<Integer> dataBuffer = new DataBuffer<>();
        Random random = new Random();
        Callable<Integer> producerAction = () -> {
            int val = random.nextInt(100);
            dataBuffer.add(val);
            return val;
        };

        Callable<Integer> consumerAction = () -> {
            int val = dataBuffer.fetch();
            return val;
        };

        final int THREAD_TOTAL = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_TOTAL);
        final int CONSUMER_TOTAL = 5;
        final int PRODUCER_TOTAL = 5;

        for (int i = 0; i < PRODUCER_TOTAL; i++) {
            executorService.submit(producerAction);
        }

        for (int i = 0; i < CONSUMER_TOTAL; i++) {
            Future<Integer> future = executorService.submit(consumerAction);
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
