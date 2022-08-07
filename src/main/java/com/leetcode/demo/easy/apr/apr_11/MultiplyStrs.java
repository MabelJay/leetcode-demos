package com.leetcode.demo.easy.apr.apr_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyStrs {

    public static void main(String[] args) {
        // 输入: num1 = "2", num2 = "3"
        //输出: "6"

        // 输入: num1 = "123", num2 = "456"
        //输出: "56088"

        // "9133"
        //"0"
        String num1 = "9133";
        String num2 = "0";

        // "123456789"
        //"987654321"


        // "498828660196"
        //"840477629533"
        System.out.println(new MultiplyStrs().multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2;
                res[i + j + 1] += sum;
            }
        }

        System.out.println(Arrays.toString(res));
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            int sum = res[i] + left;
            if (i != 0 || sum != 0) {
                sb.append(sum % 10);
            }
            left = sum / 10;
        }
        return sb.reverse().toString();
    }

    // if (num1.equals("0") || num2.equals("0")) {
    //            return "0";
    //        }
    //        int m = num1.length(), n = num2.length();
    //        int[] ansArr = new int[m + n];
    //        for (int i = m - 1; i >= 0; i--) {
    //            int x = num1.charAt(i) - '0';
    //            for (int j = n - 1; j >= 0; j--) {
    //                int y = num2.charAt(j) - '0';
    //                ansArr[i + j + 1] += x * y;
    //            }
    //        }
    //        for (int i = m + n - 1; i > 0; i--) {
    //            ansArr[i - 1] += ansArr[i] / 10;
    //            ansArr[i] %= 10;
    //        }
    //        int index = ansArr[0] == 0 ? 1 : 0;
    //        StringBuffer ans = new StringBuffer();
    //        while (index < m + n) {
    //            ans.append(ansArr[index]);
    //            index++;
    //        }
    //        return ans.toString();
}
