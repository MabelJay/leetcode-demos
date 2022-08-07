package com.leetcode.demo.easy.apr.apr_21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheTest {

    static class LRUCache {

        class DLinkNode {
            int key;
            int value;
            DLinkNode preNode;
            DLinkNode nextNode;

            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DLinkNode() {

            }
        }

        Map<Integer, DLinkNode> map = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkNode head;
        private DLinkNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.nextNode = tail;
            tail.preNode = head;
        }

        public int get(int key) {
            DLinkNode tmpNode = map.get(key);
            if (tmpNode == null) {
                return -1;
            }
            moveToHead(tmpNode);
            return tmpNode.value;
        }

        public void put(int key, int value) {
            DLinkNode tmpNode = map.get(key);
            if (tmpNode == null) {
                DLinkNode newNode = new DLinkNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    DLinkNode tail = removeTailNode();
                    map.remove(tail.key);
                    --size;
                }
            } else {
                tmpNode.value = value;
                moveToHead(tmpNode);
            }
        }

        public DLinkNode removeTailNode() {
            DLinkNode resNode = tail.preNode;
            removeNode(resNode);
            return resNode;
        }

        public void moveToHead(DLinkNode node) {
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(DLinkNode node) {
            node.preNode.nextNode = node.nextNode;
            node.nextNode.preNode = node.preNode;
        }

        public void addToHead(DLinkNode node) {
            node.preNode = head;
            node.nextNode = head.nextNode;
            head.nextNode.preNode = node;
            head.nextNode = node;
        }
    }

    public static void main(String[] args) {
        // 输入
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        //输出
        //[null, null, null, 1, null, -1, null, -1, 3, 4]

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
