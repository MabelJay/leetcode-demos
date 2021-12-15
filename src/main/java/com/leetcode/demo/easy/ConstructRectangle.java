package com.leetcode.demo.easy;

import java.util.Arrays;

public class ConstructRectangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle3(9999993)));
    }

    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        if (area <= 0) return res;

        int low = 1, high = area;
        while (low <= high) {
            if ((low * high) == area) {
                if (res[0] != 0 && res[1] != 0) {
                    int diff = res[0] - res[1];
                    if (diff > (high - low)) {
                        res[0] = high;
                        res[1] = low;
                    }
                } else {
                    res[0] = high;
                    res[1] = low;
                }
                low++;
                high--;
            } else if ((low * high) < area) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }

    public int[] constructRectangle2(int area) {
        int[] res = new int[2];
        if (area <= 0) return res;

        int left, right;
        right = (area + 1) / 2;
        left = 2;
        res = new int[]{area, 1};
        while (left <= right) {
            if (left * right == area) {
                res[0] = right;
                res[1] = left;
                left++;
                right--;
            } else if (left > (area / right)) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public int[] constructRectangle3(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
