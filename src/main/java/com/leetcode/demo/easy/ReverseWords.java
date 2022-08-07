package com.leetcode.demo.easy;

public class ReverseWords {

    public static void main(String[] args) {
        //输入："Let's take LeetCode contest"
        //输出："s'teL ekat edoCteeL tsetnoc"
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWords().reverseWords2(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 2) return s;
        int index1 = 0;
        int index2 = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 < s.length()) {
            while (index1 < s.length() && s.charAt(index1) != ' ') {
                index1++;
            }
            if (index1 > index2) {
                sb.append(reverseStr(s.substring(index2, index1)));
                if (index1 < s.length()) {
                    sb.append(s.charAt(index1));
                }
            } else {
                sb.append(s.charAt(index1));
            }
            index1++;
            index2 = index1;
        }
        return sb.toString();
    }

    public String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() < 2) return s;
        String[] arr = s.split(" ");
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            sb.append(reverseStr(arr[i]));
            sb.append(" ");
        }
        sb.append(reverseStr(arr[len - 1]));
        return sb.toString();
    }

    public String reverseWords3(String s) {
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
