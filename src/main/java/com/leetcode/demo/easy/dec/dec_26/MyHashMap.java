package com.leetcode.demo.easy.dec.dec_26;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap {

    LinkedList[] arr;
    private static final int BASE_LENGTH = 101;

    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        arr = new LinkedList[BASE_LENGTH];
        for (int i = 0; i < BASE_LENGTH; i++) {
            arr[i] = new LinkedList<Node>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Node> nodeIterator = arr[hash].iterator();
        while (nodeIterator.hasNext()) {
            Node tmpNode = nodeIterator.next();
            if (tmpNode.key == key) {
                tmpNode.value = value;
                return;
            }
        }
        arr[hash].offerLast(new Node(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator<Node> nodeIterator = arr[hash].iterator();
        while (nodeIterator.hasNext()) {
            Node tmpNode = nodeIterator.next();
            if (tmpNode.key == key) return tmpNode.value;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Node> iterator = arr[hash].iterator();
        while (iterator.hasNext()) {
            Node tmpNode = iterator.next();
            if (tmpNode.key == key) {
                arr[hash].remove(tmpNode);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE_LENGTH;
    }
}