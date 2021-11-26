package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.List;

public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        char c1 = '1';
        char c2 = '2';
//        System.out.println(c1 - 48 + 5);
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int carry = 0;
        int i = len1, j = len2;
        int v1, v2, temp;
        List<Integer> list = new ArrayList<>();
        while (i >= 0 || j >= 0) {
            v1 = i >= 0 ? (a.charAt(i) - 48) : 0;
            v2 = j >= 0 ? (b.charAt(j) - 48) : 0;
            i--;
            j--;
            temp = v1 + v2 + carry;
            list.add(temp % 2);
            carry = temp / 2;
        }
        if (carry > 0) {
            list.add(carry);
        }
        StringBuilder sb = new StringBuilder();
        for (int k = list.size() - 1; k >= 0; k--) {
            sb.append(list.get(k));
        }
        return sb.toString();
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary3(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length()), carry = 0;

        for (int i = 0; i < len; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - i - 1) - 48) : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i - 1) - 48) : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
