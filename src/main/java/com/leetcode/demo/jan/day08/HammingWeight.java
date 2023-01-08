package com.leetcode.demo.jan.day08;

public class HammingWeight {

    public static void main(String[] args) {
        // 输入：n = 11 (控制台输入 00000000000000000000000000001011)
        //输出：3
        System.out.println(new HammingWeight().hammingWeight(128));
        System.out.println(new HammingWeight().hammingWeight2(11));
        System.out.println(new HammingWeight().hammingWeight3(11));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) count++;
        }
        return count;
    }
}
