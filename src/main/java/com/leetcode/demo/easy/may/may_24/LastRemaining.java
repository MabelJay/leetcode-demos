package com.leetcode.demo.easy.may.may_24;

public class LastRemaining {

    public static void main(String[] args) {
        // 输入: n = 5, m = 3
        //输出: 3

        // 输入: n = 10, m = 17
        //输出: 2

        System.out.println(new LastRemaining().lastRemaining2(10, 17));
    }

    public int lastRemaining(int n, int m) {
        int[] arr = new int[n];
        int count = 0;
        int start = 0;
        while (count < n - 1) {
            int index = 0;
            while (index < m - 1) {
                if (arr[start] != -1) {
                    index++;
                }
                start++;
                if (start == n) start = 0;
            }
            while (start < n && arr[start] == -1) {
                start++;
                if (start == n) start = 0;
            }
            arr[start] = -1;
            count++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) return i;
        }
        return -1;
    }

    public int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
