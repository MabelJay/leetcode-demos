package com.leetcode.demo.easy;

public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance5(93, 97));
    }

    public int hammingDistance(int x, int y) {
        int num1 = Math.max(x, y);
        int num2 = (x ^ num1) == 0 ? y : x;

        int distance = 0;
        while (num1 != num2) {
            num1 = num1 >> 1;
            distance++;
        }
        return distance;
    }

    public int hammingDistance2(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);

        int len1 = s1.length();
        int len2 = s2.length();
        int count = 0;
        int index1 = len1 - 1, index2 = len2 - 1;
        while (index1 >= 0 || index2 >= 0) {
            int val1 = index1 < 0 ? '0' : s1.charAt(index1);
            int val2 = index2 < 0 ? '0' : s2.charAt(index2);

            if (val1 != val2) count++;
            index1--;
            index2--;
        }

        return count;
    }

    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance4(int x, int y) {
        int s = x ^ y, res = 0;
        while (s != 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }

    public int hammingDistance5(int x, int y) {
        int s = x ^ y, res = 0;
        while (s != 0) {
            s &= s - 1;
            res++;
        }
        return res;
    }
}
