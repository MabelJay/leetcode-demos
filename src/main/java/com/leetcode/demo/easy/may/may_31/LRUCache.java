package com.leetcode.demo.easy.may.may_31;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DListNode {
        int key;
        int value;
        DListNode pre;
        DListNode next;

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DListNode() {

        }
    }

    Map<Integer, DListNode> map;
    DListNode head;
    DListNode tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new DListNode();
        this.tail = new DListNode();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DListNode tmpNode = map.get(key);
            moveToHead(tmpNode);
            return tmpNode.value;
        }
        return -1;
    }

    public void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(DListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DListNode tmpNode = map.get(key);
            tmpNode.value = value;
            map.put(key, tmpNode);
            moveToHead(tmpNode);
        } else {
            DListNode newNode = new DListNode(key, value);
            addToHead(newNode);
            size++;
            map.put(key, newNode);
            if (size > capacity) {
                DListNode tailNode = tail.pre;
                removeNode(tailNode);
                size--;
                map.remove(tailNode.key);
            }
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
