package com.leetcode.demo.sep_05;

public class StrMultiply {

    public static void main(String[] args) {
        // 输入: num1 = "2", num2 = "3"
        //输出: "6"

        // 输入: num1 = "123", num2 = "456"
        //输出: "56088"

        // "123456789"
        //"987654321"
        System.out.println(new StrMultiply().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";

        if (num1.equals("0") || num2.equals("0")) return "0";
        String sum = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int left = 0;
            int n1 = num1.charAt(i) - '0';
            StringBuilder tmpSb = new StringBuilder();

            tmpSb.append("0".repeat(Math.max(0, num1.length() - 1 - i)));

            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                tmpSb.append((n1 * n2 + left) % 10);
                left = (n1 * n2 + left) / 10;
            }
            if (left > 0) tmpSb.append(left);
            sum = addStrings(sum, tmpSb.reverse().toString());
        }
        return sum;
    }

    public String addStrings(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? str1.charAt(i) - '0' : 0;
            int y = j >= 0 ? str2.charAt(j) - '0' : 0;
            int res = x + y + add;
            ans.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}
