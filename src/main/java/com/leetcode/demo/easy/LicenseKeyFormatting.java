package com.leetcode.demo.easy;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        //输入：S = "5F3Z-2e-9-w", K = 4
        //输出："5F3Z-2E9W"
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                count++;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (count % k == 0) {
                    sb.append("-");
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
