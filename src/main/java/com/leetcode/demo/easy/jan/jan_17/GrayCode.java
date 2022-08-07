package com.leetcode.demo.easy.jan.jan_17;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {

        // [0,1,3,2,6,7,5,4]
        System.out.println(new GrayCode().grayCode(4));

        int[] arr = {0, 1, 3, 2, 6, 7, 15, 14, 10, 11, 9, 8, 12, 13, 5, 4};
        System.out.println(new GrayCode().getBooleanOfArray(arr));
//        System.out.println(new GrayCode().containsOnly1Diff(7, 3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }

    public boolean containsOnly1Diff(int n1, int n2) {
        int res = n1 ^ n2;
        String s = Integer.toBinaryString(res);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count == 1;
    }

    public boolean getBooleanOfArray(int[] arr) {
        int init = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (!containsOnly1Diff(arr[i], init)) return false;
            init = arr[i];
        }

        return containsOnly1Diff(arr[arr.length - 1], arr[0]);
    }
}
