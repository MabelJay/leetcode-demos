package com.leetcode.demo.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private static class ListNode<K, V> {
        K key;
        V value;
        ListNode<K, V> next;
        ListNode<K, V> pre;

        ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        ListNode() {

        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    int size;
    int capacity;
    ListNode<K, V> head;
    ListNode<K, V> tail;
    Map<K, ListNode<K, V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        map = new HashMap<>();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            ListNode<K, V> curNode = map.get(key);
            deleteNode(curNode);
            moveToHead(curNode);
            return curNode.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            ListNode<K, V> curNode = map.get(key);
            curNode.value = value;
            map.put(key, curNode);
            deleteNode(curNode);
            moveToHead(curNode);
        } else {
            ListNode<K, V> tmpNode = new ListNode<>(key, value);
            moveToHead(tmpNode);
            map.put(key, tmpNode);
            size++;
            if (size > capacity) {
                ListNode<K, V> tailNode = tail.pre;
                deleteNode(tailNode);
                map.remove(tailNode.key);
                size--;
            }
        }
    }

    public void moveToHead(ListNode<K, V> node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void deleteNode(ListNode<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(4);
        cache.put(1, 2);
        cache.put(2, 3);
        System.out.println(cache.get(1));
        cache.put(3, 4);
        cache.put(4, 5);
        cache.put(5, 6);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(6, 7);
        System.out.println(cache.get(5));
        System.out.println(cache);
    }
}
