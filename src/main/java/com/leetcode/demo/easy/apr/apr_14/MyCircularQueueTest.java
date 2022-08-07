package com.leetcode.demo.easy.apr.apr_14;

public class MyCircularQueueTest {

    static class MyCircularQueue {
        int[] arr;
        int size;
        int count;
        int front;
        int rear;

        public MyCircularQueue(int k) {
            arr = new int[k];
            size = k;
            count = 0;
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            if (rear == size) rear = 0;
            arr[rear++] = value;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front++;
            count--;
            if (front == size) front = 0;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            if (rear == 0) return arr[size - 1];
            return arr[rear - 1];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }
    }

    public static void main(String[] args) {
        // MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        //circularQueue.enQueue(1);  // 返回 true
        //circularQueue.enQueue(2);  // 返回 true
        //circularQueue.enQueue(3);  // 返回 true
        //circularQueue.enQueue(4);  // 返回 false，队列已满
        //circularQueue.Rear();  // 返回 3
        //circularQueue.isFull();  // 返回 true
        //circularQueue.deQueue();  // 返回 true
        //circularQueue.enQueue(4);  // 返回 true
        //circularQueue.Rear();  // 返回 4

        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        // ["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
        //[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        //[null,true,6,6,true,true,5,true,-1,false,false,false]

        MyCircularQueue circularQueue2 = new MyCircularQueue(6);
        System.out.println(circularQueue2.enQueue(6));
        System.out.println(circularQueue2.Rear());
        System.out.println(circularQueue2.Rear());
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.enQueue(5));
        System.out.println(circularQueue2.Rear());
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.Front());
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.deQueue());
        System.out.println("-----");

        // ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
        //[[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]
        //[null,true,2,2,true,-1,false,-1,true,true,true,false]
        MyCircularQueue circularQueue3 = new MyCircularQueue(3);
        System.out.println(circularQueue3.enQueue(2));
        System.out.println(circularQueue3.Rear());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.deQueue());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.deQueue());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.enQueue(4));
        System.out.println(circularQueue3.enQueue(2));
        System.out.println(circularQueue3.enQueue(3));
        System.out.println(circularQueue3.enQueue(4));

        System.out.println("--------");
        //["MyCircularQueue","enQueue","deQueue","Front","deQueue","Front","Rear","enQueue","isFull","deQueue","Rear","enQueue"]
        //[[3],[7],[],[],[],[],[],[0],[],[],[],[3]]
        // [null,true,true,-1,false,-1,-1,true,false,true,-1,true]
    }
}
