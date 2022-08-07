package com.leetcode.demo.easy.jan.jan_4;

import java.util.Arrays;

public class Bfprt2 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 2, 5, 5, 7, 9, 10, 6};
        System.out.println(new Bfprt2().bfprt(arr, 0, arr.length - 1, 8));
    }

    public int bfprt(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int pivot = mediaOfMedias(arr, p, r);
        int[] partition = partition(arr, p, r, pivot);
        System.out.println("partition :" + Arrays.toString(partition) + " i=" + i);
        if (p + i >= partition[0] && p + i <= partition[1]) {
            return arr[partition[0]];
        } else if (p + i < partition[0]) {
            return bfprt(arr, p, partition[0] - 1, i);
        } else {
            return bfprt(arr, partition[1] + 1, r, p + i - partition[1] - 1);
        }
    }

    public int mediaOfMedias(int[] arr, int p, int r) {
        int num = r - p + 1;
        int extra = num % 5 == 0 ? 0 : 1;
        int[] medias = new int[num / 5 + extra];

        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, p + i * 5, Math.min(p + i * 5 + 4, r));
        }

        return bfprt(medias, 0, medias.length - 1, medias.length / 2);
    }

    public int computeMedia(int[] arr, int p, int r) {
        int temp, i;
        for (int j = p + 1; j <= r; j++) {
            temp = arr[j];
            i = j - 1;
            while (i >= p && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr[(p + r) / 2];
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
}
