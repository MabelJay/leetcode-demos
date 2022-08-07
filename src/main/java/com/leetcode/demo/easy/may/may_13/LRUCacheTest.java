package com.leetcode.demo.easy.may.may_13;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    static class LRUCache<T> {
        class DListNode {
            T key;
            T value;
            DListNode pre;
            DListNode next;

            public DListNode() {
            }

            public DListNode(T key, T value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<T, DListNode> map;
        DListNode head;
        DListNode tail;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new DListNode();
            tail = new DListNode();
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
            size = 0;
        }

        public T get(T key) {
            if (map.containsKey(key)) {
                DListNode tmpNode = map.get(key);
                removeNode(tmpNode);
                addToHead(tmpNode);
                return tmpNode.value;
            }
            return null;
        }

        public void put(T key, T value) {
            if (map.containsKey(key)) {
                DListNode tmpNode = map.get(key);
                tmpNode.value = value;
                removeNode(tmpNode);
                addToHead(tmpNode);
                map.put(key, tmpNode);
            } else {
                size++;
                DListNode newNode = new DListNode(key, value);
                addToHead(newNode);
                map.put(key, newNode);
                if (size > capacity) {
                    DListNode tailNode = tail.pre;
                    removeNode(tailNode);
                    size--;
                    map.remove(tailNode.key);
                }
            }
        }

        public void addToHead(DListNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(DListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(2);
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
