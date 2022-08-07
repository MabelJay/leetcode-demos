package com.leetcode.demo.easy.apr.apr_12;

public class ReverseVowels {

    public static void main(String[] args) {
        // 输入：s = "hello"
        //输出："holle"

        //输入：s = "leetcode"
        //输出："leotcede"

        String s = "aA";
        System.out.println(new ReverseVowels().reverseVowels2(s));
    }

    public String reverseVowels2(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !isVowels(arr[left])) {
                left++;
            }

            while (left < right && !isVowels(arr[right])) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowels(s.charAt(left))) {
                left++;
            }
            while (left < right && !isVowels(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                swap(sb, left, right);
            }
            left++;
            right--;
        }
        return sb.toString();
    }

    public void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public boolean isVowels(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    // if (s == null || s.length() == 0) return s;
    //
    //        char[] arr = s.toCharArray();
    //        int left = 0, right = arr.length - 1;
    //
    //        while (left < right) {
    //            while (left < right && !isVowel(arr[left])) {
    //                left++;
    //            }
    //
    //            while (left < right && !isVowel(arr[right])) {
    //                right--;
    //            }
    //
    //            if (left < right) {
    //                swap(arr, left, right);
    //                left++;
    //                right--;
    //            }
    //        }
    //        return new String(arr);
    //    }
    //    public boolean isVowel(char ch) {
    //        return "aeiouAEIOU".indexOf(ch) >= 0;
    //    }
    //
    //    public void swap(char[] arr, int i, int j) {
    //        char temp = arr[i];
    //        arr[i] = arr[j];
    //        arr[j] = temp;
    //    }
}
