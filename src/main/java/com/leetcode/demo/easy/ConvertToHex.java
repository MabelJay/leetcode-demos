package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertToHex {

    public static void main(String[] args) {
        System.out.println(new ConvertToHex().toHex(-1));
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
