package com.leetcode.demo.aug_20;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        // 输入：strs = ["flower","flow","flight"]
        //输出："fl"
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"ab", "a"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs2));
    }

    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String tmp = strs[i];
            int index = 0;
            StringBuilder sb = new StringBuilder();
            while (index < pre.length() && index < tmp.length()) {
                if (pre.charAt(index) == tmp.charAt(index)) {
                    sb.append(pre.charAt(index));
                    index++;
                } else {
                    break;
                }
            }
            pre = sb.toString();
        }
        return pre;
    }
}
