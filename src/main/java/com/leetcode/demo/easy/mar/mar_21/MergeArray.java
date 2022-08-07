package com.leetcode.demo.easy.mar.mar_21;

import java.util.Arrays;

public class MergeArray {

    public static void main(String[] args) {
        // 输入:
        //A = [1,2,3,0,0,0], m = 3
        //B = [2,5,6],       n = 3
        //
        //输出: [1,2,2,3,5,6]

        //[0]
        //0
        //[1]
        //1
        //{1}

        int[] A = {0};
        int[] B = {1};
        new MergeArray().merge(A, 0, B, 1);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int index1 = 0, index2 = 0;
        while (index1 <= m + index2 && index2 < n) {
            while (index1 < m + index2 && B[index2] >= A[index1]) {
                index1++;
            }
            if (index1 >= m + index2) {
                while (index1 < A.length) {
                    A[index1++] = B[index2++];
                }
                break;
            } else {
                int i = A.length - 2;
                while (i >= index1) {
                    A[i + 1] = A[i];
                    i--;
                }
                A[index1] = B[index2];
                index2++;
                index1++;
            }
        }
    }
}
