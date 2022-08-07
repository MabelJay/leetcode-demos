package com.leetcode.demo.easy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        // 输入：flowerbed = [1,0,0,0,1], n = 1
        //输出：true

        //[0]
        //1
        int[] flowerbed = {0};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers2(flowerbed, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;
        if (n < 1) return true;
        if (flowerbed.length == 1) {
            if (n == 1 && flowerbed[0] == 0) return true;
        }
        int pre = 0;
        int index = 1;
        while (index < flowerbed.length) {
            if (pre == 0 && flowerbed[pre] == 0 && flowerbed[index] == 0) {
                n--;
                flowerbed[pre] = 1;
            }
            if (index == flowerbed.length - 1 && flowerbed[index] == 0 && flowerbed[index - 1] == 0) {
                n--;
                flowerbed[index] = 1;
            }
            if (flowerbed[pre] == 0 && flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
                n--;
                flowerbed[index] = 1;
            }
            pre = index;
            index++;
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
}
