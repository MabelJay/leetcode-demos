package com.leetcode.demo.dec.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hanota {

    public static void main(String[] args) {
        // 输入：A = [2, 1, 0], B = [], C = []
        // 输出：C = [2, 1, 0]
        List<Integer> listA = new ArrayList<>();
        listA.add(2);
        listA.add(1);
        listA.add(0);

        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        new Hanota().hanota(listA, listB, listC);
        System.out.println(listC);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        func(n, A, C, B);
    }

    public void func(int i, List<Integer> fromList, List<Integer> toList, List<Integer> otherList) {
        if (i == 1) {
            int num = fromList.remove(fromList.size() - 1);
            toList.add(num);
        } else {
            func(i - 1, fromList, otherList, toList);
            int num = fromList.remove(fromList.size() - 1);
            toList.add(num);
            func(i - 1, otherList, toList, fromList);
        }
    }
}
