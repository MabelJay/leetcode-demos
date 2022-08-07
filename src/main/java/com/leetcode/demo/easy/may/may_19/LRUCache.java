package com.leetcode.demo.easy.may.may_19;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class DListNode {
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
    int size;
    int capacity;
    DListNode head;
    DListNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DListNode tmpNode = map.get(key);
            tmpNode.value = value;
            map.put(key, tmpNode);
            addToHead(tmpNode);
        } else {
            DListNode newNode = new DListNode(key, value);
            moveToHead(newNode);
            map.put(key, newNode);
            size++;
            if (size > capacity) {
                DListNode tailNode = tail.pre;
                removeNode(tailNode);
                map.remove(tailNode.key);
                size--;
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DListNode tmpNode = map.get(key);
            addToHead(tmpNode);
            return tmpNode.value;
        }
        return -1;
    }

    public void addToHead(DListNode node) {
        removeNode(node);
        moveToHead(node);
    }

    public void moveToHead(DListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));

        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}
