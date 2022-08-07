package com.leetcode.demo.easy.apr.apr_15;

import java.util.Arrays;

public class CircularQueueTest {

    static class MyCircularDeque {

        int[] innerArr;
        int count;
        int size;

        public MyCircularDeque(int k) {
            innerArr = new int[k];
            Arrays.fill(innerArr, -1);
            count = 0;
            size = k;
        }

        public boolean insertFront(int value) {
            if (!isFull()) {
                int index = 0;
                while (index < size && innerArr[index] != -1) {
                    index++;
                }
                while (index > 0) {
                    innerArr[index] = innerArr[index - 1];
                    index--;
                }
                innerArr[0] = value;
                count++;
                return true;
            }
            return false;
        }

        public boolean insertLast(int value) {
            if (!isFull()) {
                int index = size - 1;
                while (index >= 0 && innerArr[index] != -1) {
                    index--;
                }
                while (index < size - 1) {
                    innerArr[index] = innerArr[index + 1];
                    index++;
                }
                innerArr[index] = value;
                count++;
                return true;
            }
            return false;
        }

        public boolean deleteFront() {
            if (!isEmpty()) {
                int index = 0;
                while (index < size && innerArr[index] == -1) {
                    index++;
                }
                innerArr[index] = -1;
                count--;
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (!isEmpty()) {
                int index = size - 1;
                while (index >= 0 && innerArr[index] == -1) {
                    index--;
                }
                innerArr[index] = -1;
                count--;
                return true;
            }
            return false;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            int index = 0;
            while (index < size) {
                if (innerArr[index] != -1) return innerArr[index];
                index++;
            }
            return -1;
        }

        public int getRear() {
            if (isEmpty()) return -1;
            int index = size - 1;
            while (index >= 0) {
                if (innerArr[index] != -1) return innerArr[index];
                index--;
            }
            return -1;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }
    }

    public static void main(String[] args) {
        // ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
        //[[3], [1], [2], [3], [4], [], [], [], [4], []]
        //输出
        //[null, true, true, true, false, 2, true, true, true, 4]

        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());
    }
}
