package com.leetcode.demo.easy.may.may_16;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    private static class ThreadImpl extends Thread {

        private ThreadImpl(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is executing...");
        }
    }

    private static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " is executing runnable ");
        }
    }


    private static class CallableImpl implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread() + " is executing callable ");
            return "done";
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadImpl thread1 = new ThreadImpl("thread-1");
        thread1.start();

        Thread thread2 = new Thread(new RunnableImpl(), "thread-2");
        thread2.start();

        FutureTask<String> task = new FutureTask<>(new CallableImpl());
        Thread thread3 = new Thread(task, "thread-3");
        thread3.start();
        System.out.println(task.get());
    }
}
