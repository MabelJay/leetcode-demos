package com.leetcode.demo.easy.dec.dec_30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public static void main(String[] args) {
        // 输入：aliceSizes = [1,1], bobSizes = [2,2]
        //输出：[1,2]

        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};
        System.out.println(Arrays.toString(new FairCandySwap().fairCandySwap(aliceSizes, bobSizes)));
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int num = (sumA - sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int val : bobSizes) {
            set.add(val);
        }

        for (int val : aliceSizes) {
            if (set.contains(val - num)) return new int[]{val, val - num};
        }
        return new int[2];
    }
}
