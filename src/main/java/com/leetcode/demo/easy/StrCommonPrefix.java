package com.leetcode.demo.easy;

public class StrCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        StrCommonPrefix commonPrefix = new StrCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix4(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";

        String prefix = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        int length = strs[0].length();
        int arrLen = strs.length;

        for (int i = 0; i < length; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < arrLen; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        if (start < end) {
            int center = (start + end) / 2;
            String leftStr = longestCommonPrefix(strs, start, center);
            String rightStr = longestCommonPrefix(strs, center + 1, end);
            return commonPrefix(leftStr, rightStr);
        }
        return "";
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int len = Math.min(lcpLeft.length(), lcpRight.length());
        int index = 0;

        while (index < len) {
            if (lcpLeft.charAt(index) == lcpRight.charAt(index)) {
                index++;
            } else {
                return lcpLeft.substring(0, index);
            }
        }
        return lcpLeft.substring(0, index);
    }

    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length < 1) return "";

        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int low = 0, high = minLen - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String commonStr = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String temp = strs[i];
            for (int j = 0; j < commonStr.length(); j++) {
                if (temp.charAt(j) != commonStr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
