package com.leetcode.demo.easy.dec.dec_27;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static void main(String[] args) {
        //输入：
        //上边界left = 1, 下边界right = 22
        //输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        System.out.println(new SelfDividingNumbers().isSelfDividingNum(10));
        System.out.println(new SelfDividingNumbers().selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> resList = new ArrayList<>();
        if (left > right) return resList;
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNum(i)) resList.add(i);
        }
        return resList;
    }

    public boolean isSelfDividingNum(int num) {
        int temp = num;
        while (temp != 0) {
            int left = temp % 10;
            if (left==0 || (num % left) != 0) return false;
            temp = temp / 10;
        }
        return true;
    }
}
