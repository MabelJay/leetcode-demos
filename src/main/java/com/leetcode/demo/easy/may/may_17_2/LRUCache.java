package com.leetcode.demo.easy.may.may_17_2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode() {

        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    Map<Integer, DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkNode tmpNode = map.get(key);
            tmpNode.value = value;
            map.put(key, tmpNode);
            addToHead(tmpNode);
        } else {
            DLinkNode tmpNode = new DLinkNode(key, value);
            moveToHead(tmpNode);
            map.put(key, tmpNode);
            size++;
            if (size > capacity) {
                DLinkNode tailNode = tail.pre;
                removeNode(tailNode);
                size--;
                map.remove(tailNode.key);
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkNode tmpNode = map.get(key);
            addToHead(tmpNode);
            return tmpNode.value;
        }
        return -1;
    }

    public void addToHead(DLinkNode node) {
        removeNode(node);
        moveToHead(node);
    }

    public void moveToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(1));
        cache.put(4, 4);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
