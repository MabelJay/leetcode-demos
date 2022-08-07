package com.leetcode.demo.easy.dec.dec_29;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public static void main(String[] args) {
        // 输入：jewels = "aA", stones = "aAAbbbb"
        //输出：3

        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(new NumJewelsInStones().numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
