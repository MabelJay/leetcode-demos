package com.leetcode.demo.easy.may.may_16;

import java.util.BitSet;

public class BitSetTest {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(1 << 3);
        bitSet.set(4);
        System.out.println(bitSet.get(4));
        System.out.println(bitSet.length());
        System.out.println(1<<3);
    }
}
