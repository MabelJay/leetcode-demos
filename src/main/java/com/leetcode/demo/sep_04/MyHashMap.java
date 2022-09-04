package com.leetcode.demo.sep_04;

import java.util.*;

public class MyHashMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

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

        public final K getKey() {
            return key;
        }

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
                return Objects.equals(e.getKey(), key) && Objects.equals(e.getValue(), value);
            }
            return false;
        }
    }

    public final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    Node<K, V>[] tab;
    int size;
    final float loadFactor;
    int threshold;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }

        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            throw new RuntimeException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public MyHashMap(int loadCapacity) {
        this(loadCapacity, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }

    public boolean containsValue(Object value) {
        Node<K, V>[] table;
        if ((table = tab) != null && size > 0) {
            for (Node<K, V> e : table) {
                while (e != null) {
                    if (e.value == value || (value != null && value.equals(e.value))) {
                        return true;
                    }
                    e = e.next;
                }
            }
        }
        return false;
    }

    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K, V> getNode(int hash, Object key) {
        Node<K, V> first;
        if (tab != null && tab.length > 0 && (first = tab[(tab.length - 1) & hash]) != null) {
            if (first.hash == hash && (first.key == key || (key != null && key.equals(first.key)))) {
                return first;
            }
            Node<K, V> e = first.next;
            while (e != null) {
                if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                    return e;
                }
                e = e.next;
            }
        }
        return null;
    }

    private Node<K, V>[] resize() {
        if (threshold > 0) {
            tab = (Node<K, V>[]) new Node[threshold];
        } else {
            tab = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
        }
        return tab;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    public V putVal(int hash, K key, V value) {
        int i;
        Node<K, V> e;
        if (tab == null || tab.length == 0) {
            resize();
        }
        int len = tab.length;
        if (tab[i = (len - 1) & hash] == null) {
            tab[i] = new Node<>(hash, key, value, null);
            size++;
        } else {
            Node<K, V> first = tab[i];
            if (first.hash == hash && (first.key == key || (key != null && key.equals(first.key)))) {
                e = first;
            } else {
                for (int j = 0; ; j++) {
                    if ((e = first.next) == null) {
                        first.next = new Node<>(hash, key, value, null);
                        size++;
                        break;
                    }

                    if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                        break;
                    }
                }
                if (e != null) {
                    V oldVal = e.value;
                    e.value = value;
                    return oldVal;
                }
            }
        }
        return null;
    }
}
