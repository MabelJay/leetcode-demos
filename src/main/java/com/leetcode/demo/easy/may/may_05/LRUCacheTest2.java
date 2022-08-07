package com.leetcode.demo.easy.may.may_05;

import com.leetcode.demo.easy.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTest2 {
    static class LRUCache {

        class DNode {
            int key;
            int value;
            DNode next;
            DNode pre;

            public DNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DNode() {

            }
        }

        DNode head;
        DNode tail;
        Map<Integer, DNode> map;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DNode();
            tail = new DNode();
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DNode tmpNode = map.get(key);
                moveToHead(tmpNode);
                return tmpNode.value;
            }
            return -1;
        }

        public void removeNode(DNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(DNode node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void moveToHead(DNode node) {
            removeNode(node);
            addToHead(node);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DNode tmpNode = map.get(key);
                tmpNode.value = value;
                moveToHead(tmpNode);
                map.put(key, tmpNode);
            } else {
                size++;
                DNode newNode = new DNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                if (size > capacity) {
                    DNode tmpNode = tail.pre;
                    removeNode(tmpNode);
                    map.remove(tmpNode.key);
                    size--;
                }
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}
