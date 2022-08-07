package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public static void main(String[] args) {
        int[] candyType = {0, 0, 0, 4};
        System.out.println(new DistributeCandies().distributeCandies3(candyType));
    }

    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) return 0;
        int halfLen = candyType.length / 2;

        Set<Integer> set = new HashSet<>();
        for (Integer type : candyType) {
            set.add(type);
        }
        int typeSize = set.size();
        return Math.min(halfLen, typeSize);
    }

    public int distributeCandies2(int[] candyType) {
        if (candyType == null || candyType.length == 0) return 0;
        int halfLen = candyType.length / 2;
        Arrays.sort(candyType);
        int count = 1;
        int pre = 0, cur = 1;
        while (count < halfLen) {
            while (cur < candyType.length && candyType[cur] == candyType[pre]) {
                cur++;
                pre++;
            }
            if (cur < candyType.length) count++;
            else break;
            cur++;
            pre++;
        }
        return count;
    }

    public int distributeCandies3(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
