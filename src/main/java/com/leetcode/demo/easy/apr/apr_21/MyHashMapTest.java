package com.leetcode.demo.easy.apr.apr_21;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMapTest {

    static class MyHashMap {

        class Node {
            int key;
            int value;

            public void setValue(int value) {
                this.value = value;
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }

        LinkedList<Node>[] arr;
        private static final int threshHold = 101;

        public MyHashMap() {
            arr = new LinkedList[threshHold];
            for (int i = 0; i < threshHold; i++) {
                arr[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int hash = hash(key);
            Iterator<Node> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                Node tmpNode = iterator.next();
                if (tmpNode.key == key) {
                    tmpNode.setValue(value);
                    return;
                }
            }
            arr[hash].offerLast(new Node(key, value));
        }

        public int get(int key) {
            int hash = hash(key);
            Iterator<Node> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                Node tmpNode = iterator.next();
                if (tmpNode.key == key) return tmpNode.value;
            }
            return -1;
        }

        public void remove(int key) {
            int hash = hash(key);
            Iterator<Node> iterator = arr[hash].iterator();
            while (iterator.hasNext()) {
                Node tmpNode = iterator.next();
                if (tmpNode.key == key) {
                    arr[hash].remove(tmpNode);
                    return;
                }
            }
        }

        public int hash(int key) {
            return key % threshHold;
        }
    }

    public static void main(String[] args) {
        // ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
        //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
        //输出：
        //[null, null, null, 1, -1, null, 1, null, -1]

        MyHashMap map = new MyHashMap();
//        map.put(1, 1);
        map.put(2, 2);
//        System.out.println(map.get(1));
//        System.out.println(map.get(3));
//        System.out.println(map.get(2));
        map.put(2, 1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
