package com.leetcode.demo.easy.may.may_14;

import java.util.BitSet;

public class BloomFilter {

    private static final int DEFAULT_SIZE = 256 << 22;

    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};

    private static HashFunction[] functions = new HashFunction[seeds.length];

    private static BitSet bitSet = new BitSet(DEFAULT_SIZE);

    public static void add(String value) {
        if (value != null) {
            for (HashFunction function : functions) {
                bitSet.set(function.hash(value), true);
            }
        }
    }

    public static boolean contains(String value) {
        if (value == null) return false;
        boolean result;
        for (HashFunction function : functions) {
            result = bitSet.get(function.hash(value));
            if (!result) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(seeds[i], DEFAULT_SIZE);
        }

        for (int i = 0; i < 10000; i++) {
            add(String.valueOf(i));
        }
        String id = "123456789";
        add(id);
        System.out.println(contains(id));   // true
        System.out.println("" + contains("234567890"));  //false
        System.out.println("" + contains("111"));
    }

    static class HashFunction {
        private int size;
        private int seed;

        public HashFunction(int seed, int size) {
            this.seed = seed;
            this.size = size;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();

            for (int i = 0; i < len; i++) {
                result += result * seed + value.charAt(i);
            }
            return (size - 1) & result;
        }
    }
}
