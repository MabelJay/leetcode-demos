package com.leetcode.demo.easy.may.may_02;

import java.util.HashMap;
import java.util.Map;

public class LruCacheTest {
    static class LRUCache {

        class DNode {
            int key;
            int value;

            DNode pre;
            DNode next;

            public DNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DNode() {

            }
        }

        Map<Integer, DNode> map = new HashMap<>();
        DNode head;
        DNode tail;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DNode();
            tail = new DNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DNode tmpNode = map.get(key);
                moveToHead(tmpNode);
                return tmpNode.value;
            }
            return -1;
        }

        public void moveToHead(DNode node) {
            removeNode(node);
            addToHead(node);
        }

        public void addToHead(DNode node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(DNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public DNode removeTailNode() {
            DNode tmpNode = tail.pre;
            removeNode(tmpNode);
            return tmpNode;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DNode tmpNode = map.get(key);
                moveToHead(tmpNode);
                tmpNode.value = value;
                map.put(key, tmpNode);
            } else {
                DNode newNode = new DNode(key, value);
                size++;
                addToHead(newNode);
                map.put(key, newNode);
                if (size > capacity) {
                    DNode tailNode = removeTailNode();
                    map.remove(tailNode.key);
                    size--;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 输入
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        // [null, null, null, 1, null, -1, null, -1, 3, 4]

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
