package com.leetcode.demo.easy.jan.jan_7;

public class Multiply {

    public static void main(String[] args) {
        //输入: num1 = "123", num2 = "456"
        //输出: "56088"

        System.out.println(new Multiply().multiply("567", "1234"));
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = m - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < m - 1; j++) {
                sb.append("0");
            }
            int val1 = num1.charAt(i) - '0';
            int left = 0;
            for (int j = n - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                int multiRes = val1 * val2 + left;
                sb.append(multiRes % 10);
                left = multiRes / 10;
            }
            if (left > 0) {
                sb.append(left % 10);
            }

            ans = addString(ans, sb.reverse().toString());
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();

    }

    public String addString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = len1 - 1, j = len2 - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int res = x1 + x2 + add;
            sb.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public String singleMultiply(String num1, int num2) {
        int len1 = num1.length();
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len1 - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            int multiVal = val1 * num2 + left;
            sb.append(multiVal % 10);
            left = multiVal / 10;
        }
        if (left > 0) {
            sb.append(left);
        }
        return sb.reverse().toString();
    }
}
