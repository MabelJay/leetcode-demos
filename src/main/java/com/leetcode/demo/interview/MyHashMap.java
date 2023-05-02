package com.leetcode.demo.interview;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    int size;
    float loadFactor;
    int threshold;
    Node<K, V>[] table;

    static class Node<K, V> implements Map.Entry<K, V> {

        int hash;
        K key;
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
            V oldVal = value;
            this.value = newValue;
            return oldVal;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) o;
                if (Objects.equals(entry.getKey(), key) && Objects.equals(entry.getValue(), value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key) ^ Objects.hash(value);
        }
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor:" + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = initialCapacity;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = DEFAULT_INITIAL_CAPACITY;
    }

    private static int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (table != null && size > 0) {
            for (Node<K, V> e : table) {
                while (e != null) {
                    if (value == e.value || (Objects.equals(value, e.value))) {
                        return true;
                    }
                    e = e.next;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> e = getNode(hash(key), key);
        return (e == null) ? null : e.value;
    }

    private Node<K, V> getNode(int hash, Object key) {
        int n;
        Node<K, V> first, e;
        if (table != null && (n = table.length) > 0 && (first = table[(n - 1) & hash]) != null) {
            if (first.hash == hash && Objects.equals(key, first.key)) {
                return first;
            }
            while ((e = first.next) != null) {
                if (e.hash == hash && Objects.equals(key, e.key)) {
                    return e;
                }
                first = e;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        int index;
        int len;
        if (table == null || table.length == 0) {
            if (threshold > 0) {
                table = new Node[threshold];
            } else table = new Node[DEFAULT_INITIAL_CAPACITY];
        }
        len = table.length;
        index = (len - 1) & hash;
        if (table[index] == null) {
            table[index] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;
            Node<K, V> p = table[index];
            if (p.hash == hash && (Objects.equals(key, p.key))) {
                e = p;
            } else {
                while (true) {
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash && Objects.equals(key, e.key)) {
                        break;
                    }
                    p = e;
                }
            }
            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        size++;
        if (size > threshold) {
            throw new RuntimeException("no enough space");
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        Node<K, V> p, e;
        Node<K, V> node = null;
        int hash = hash(key);
        if (table != null && size > 0) {
            int index = (table.length - 1) & hash;
            p = table[index];
            if (p != null) {
                if (p.hash == hash && Objects.equals(key, p.key)) {
                    node = p;
                } else if ((e = p.next) != null) {
                    while (e != null) {
                        if (e.hash == hash && Objects.equals(key, e.key)) {
                            node = e;
                            break;
                        }
                        p = e;
                        e = e.next;
                    }
                }
                if (node != null) {
                    if (node == p) {
                        table[index] = node.next;
                    } else {
                        p.next = node.next;
                    }
                    size--;
                    return node.value;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            size = 0;
            Arrays.fill(table, null);
        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        System.out.println(map.size());

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue(2));

        System.out.println(map.size());
        map.remove(1);
        System.out.println(map.containsKey(1));
        System.out.println(map.size());

        map.clear();
        System.out.println(map.size());
    }
}
