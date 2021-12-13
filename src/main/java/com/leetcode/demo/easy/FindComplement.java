package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.List;

public class FindComplement {

    public static void main(String[] args) {
        System.out.println(new FindComplement().findComplement2(5));
    }

    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(49 - s.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < sb.length(); i++) {
            int temp = sb.charAt(i) - 48;
            res += temp * Math.pow(2, sb.length() - i - 1);
        }
        return res;
    }

    public int findComplement2(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
