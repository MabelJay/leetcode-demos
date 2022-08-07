package com.leetcode.demo.easy.apr.apr_17;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        // 8  6

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { //注意while处理多个case  int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(new Main1().deleteNum(b));
        }
    }

    public int deleteNum(int n) {
        int[] arr = new int[n];
        int index = 0;
        int count = 0;
        int resIndex = -1;
        while (count < n) {
            int freq = 2;
            while (freq > 0) {
                if (arr[index] != -1) {
                    freq--;
                }
                index++;
                if (index == n) {
                    index = 0;
                    while (index < n && arr[index] == -1) {
                        index++;
                    }
                }
            }
            while (index < n && arr[index] == -1) {
                index++;
                if (index == n) {
                    index = 0;
                }
            }
            arr[index] = -1;
            resIndex = index;
            count++;
        }
        return resIndex;
    }
}
