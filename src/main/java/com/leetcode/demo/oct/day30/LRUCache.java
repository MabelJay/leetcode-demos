package com.leetcode.demo.oct.day30;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {

    private static class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        ListNode() {

        }
    }

    int size;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode curNode = map.get(key);
            deleteNode(curNode);
            moveToHead(curNode);
            return curNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode curNode = map.get(key);
            curNode.val = value;
            map.put(key, curNode);
            deleteNode(curNode);
            moveToHead(curNode);
        } else {
            ListNode node = new ListNode(key, value);
            size++;
            map.put(key, node);
            moveToHead(node);
            if (size > capacity) {
                ListNode tailNode = tail.pre;
                deleteNode(tailNode);
                map.remove(tailNode.key);
                size--;
            }
        }
    }

    public void moveToHead(ListNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        // 输入
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        //输出
        //[null, null, null, 1, null, -1, null, -1, 3, 4
        //]
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