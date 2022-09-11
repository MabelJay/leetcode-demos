package com.leetcode.demo.sep_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap2<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(e.getKey(), key) && Objects.equals(e.getValue(), value)) {
                    return true;
                }
            }
            return false;
        }
    }

    Node<K, V>[] tab;
    private int size;
    int threshold;
    final float loadFactor;

    public MyHashMap2() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap2(int loadCapacity) {
        this(loadCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap2(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        this.loadFactor = loadFactor;
        this.threshold = initialCapacity;
        tab = new Node[threshold];
    }

    public final int hash(K key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ h >>> 16);
    }

    public V get(K key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    private Node<K, V> getNode(int hash, K key) {
        Node<K, V> first;
        if (tab != null && tab.length > 0 && (first = tab[(tab.length - 1) & hash]) != null) {
            if (first.hash == hash && Objects.equals(first.key, key)) {
                return first;
            }
            Node<K, V> e = first.next;
            while (e != null) {
                if (e.hash == hash && Objects.equals(e.key, key)) {
                    return e;
                }
                e = e.next;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        int i;
        Node<K, V> e;
        if (tab != null && tab.length > 0) {
            if (tab[i = (tab.length - 1) & hash] == null) {
                tab[i] = new Node<>(hash, key, value, null);
                size++;
            } else {
                Node<K, V> first = tab[i];
                if (first.hash == hash && Objects.equals(first.key, key)) {
                    e = first;
                } else {
                    for (int j = 0; ; j++) {
                        if ((e = first.next) == null) {
                            first.next = new Node<>(hash, key, value, null);
                            size++;
                            break;
                        }
                        if (e.hash == hash && Objects.equals(e.key, key)) {
                            break;
                        }
                    }
                }
                if (e != null) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}
