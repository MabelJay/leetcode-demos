package com.leetcode.demo.easy.apr.apr_10;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        // 输入：strs = ["flower","flow","flight"]
        //输出："fl"

        // 输入：strs = ["dog","racecar","car"]
        //输出：""
        //解释：输入不存在公共前缀。

        // ["reflower","flow","flight"]
        //""

        // ["acc","aaa","aaba"]
        // "a"
        String[] strs = {"acc","aaa","aaba"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(strs));
    }

    public String longestCommonPrefix2(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < minLen) {
            char temp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != temp) return sb.toString();
            }
            sb.append(temp);
            index++;
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            temp = commonPrefix(strs[i], temp);
            if (temp.equals("")) return temp;
        }
        return temp;
    }

    public String commonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int commonLen = Math.min(len1, len2);
        while (index < commonLen && s1.charAt(index) == s2.charAt(index)) {
            sb.append(s1.charAt(index));
            index++;
        }
        return sb.toString();
    }

    // public String longestCommonPrefix(String[] strs) {
    //        if (strs == null || strs.length == 0) return "";
    //        return longestCommonPrefix(strs, 0, strs.length - 1);
    //    }
    //
    //    public String longestCommonPrefix(String[] strs, int start, int end) {
    //        if (start == end) return strs[start];
    //        if (start < end) {
    //            int center = (start + end) / 2;
    //            String leftStr = longestCommonPrefix(strs, start, center);
    //            String rightStr = longestCommonPrefix(strs, center + 1, end);
    //            return commonPrefix(leftStr, rightStr);
    //        }
    //        return "";
    //    }
    //
    //    public String commonPrefix(String lcpLeft, String lcpRight) {
    //        int len = Math.min(lcpLeft.length(), lcpRight.length());
    //        int index = 0;
    //
    //        while (index < len) {
    //            if (lcpLeft.charAt(index) == lcpRight.charAt(index)) {
    //                index++;
    //            } else {
    //                return lcpLeft.substring(0, index);
    //            }
    //        }
    //        return lcpLeft.substring(0, index);
    //    }
}
