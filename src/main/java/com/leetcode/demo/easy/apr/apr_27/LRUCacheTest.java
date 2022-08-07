package com.leetcode.demo.easy.apr.apr_27;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    static class LRUCache {

        class DNode {
            int key;
            int value;
            DNode pre;
            DNode next;

            public DNode() {
            }

            public DNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, DNode> map;

        int size;
        int capacity;
        DNode head;
        DNode tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;
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

        public void removeNode(DNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
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

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DNode tmpNode = map.get(key);
                tmpNode.value = value;
                moveToHead(tmpNode);
                map.put(key, tmpNode);
            } else {
                DNode newNode = new DNode(key, value);
                addToHead(newNode);
                map.put(key, newNode);
                size++;
                if (size > capacity) {
                    DNode node = removeTail();
                    map.remove(node.key);
                    size--;
                }
            }
        }

        public DNode removeTail() {
            DNode tmpNode = tail.pre;
            removeNode(tmpNode);
            return tmpNode;
        }
    }

    public static void main(String[] args) {
        // LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        //
        //cache.put(1, 1);
        //cache.put(2, 2);
        //cache.get(1);       // 返回  1
        //cache.put(3, 3);    // 该操作会使得密钥 2 作废
        //cache.get(2);       // 返回 -1 (未找到)
        //cache.put(4, 4);    // 该操作会使得密钥 1 作废
        //cache.get(1);       // 返回 -1 (未找到)
        //cache.get(3);       // 返回  3
        //cache.get(4);       // 返回  4

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
