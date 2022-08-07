package com.leetcode.demo.easy.jan.jan_3;

import java.util.Arrays;
import java.util.Random;

public class Bfprt {

    public static void main(String[] args) {
        int[] arr = {49, 30, 51, 60, 31, 44};
        Bfprt bfprt = new Bfprt();
//        System.out.println(bfprt.computeMedia(arr, 1, 6));
        System.out.println(bfprt.bfprt(arr, 0, arr.length - 1, 2));
    }

    public int[] generateArray(int len) {
        int[] res = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            res[i] = random.nextInt(100);
        }
        return res;
    }

    public int mediaOfMedias(int[] arr, int p, int r) {
        int num = r - p + 1;
        int extra = num % 5 == 0 ? 0 : 1;
        int[] medias = new int[num / 5 + extra];
        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, p + 5 * i, Math.min(p + 5 * i + 4, r));
        }
        return bfprt(medias, 0, medias.length - 1, medias.length / 2);
    }

    public int bfprt(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int pivot = mediaOfMedias(arr, p, r);
        int[] pivotRange = partition(arr, p, r, pivot);
        if (p + i >= pivotRange[0] && p + i <= pivotRange[1]) {
            return arr[pivotRange[0]];
        } else if (p + i < pivotRange[0]) {
            return bfprt(arr, p, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, r, i + p - pivotRange[1] - 1);
        }

    }

    public int[] partition(int[] arr, int p, int r, int pivot) {
        int small = p - 1;
        int equal = 0;
        int temp;

        for (int j = p; j <= r; j++) {
            if (arr[j] < pivot) {
                small++;
                temp = arr[small];
                arr[small] = arr[j];
                if (equal > 0) {
                    arr[j] = arr[small + equal];
                    arr[small + equal] = temp;
                } else {
                    arr[j] = temp;
                }
            } else if (arr[j] == pivot) {
                equal++;
                temp = arr[j];
                arr[j] = arr[small + equal];
                arr[small + equal] = temp;
            }
        }
        return new int[]{small + 1, small + equal};
    }

    public int computeMedia(int[] arr, int begin, int end) {
        int temp, i;
        for (int j = begin + 1; j <= end; j++) {
            temp = arr[j];
            i = j - 1;

            while (i >= begin && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr[(end + begin) / 2];
    }
}
