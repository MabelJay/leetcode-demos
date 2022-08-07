package com.leetcode.demo.easy.apr.apr_10;

public class CanConstruct {

    public static void main(String[] args) {
        // 输入：ransomNote = "aa", magazine = "aab"
        //输出：true

        System.out.println('a' - 0);
        String ransomNote = "aa";
        String magazine = "ab";

        // 输入：ransomNote = "aa", magazine = "ab"
        //输出：false
        System.out.println(new CanConstruct().canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineArr[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 97;
            magazineArr[index]--;
            if (magazineArr[index] < 0) return false;
        }
        return true;
    }

    // if (ransomNote == null || magazine == null) return false;
    //
    //        char[] arr1 = ransomNote.toCharArray();
    //        char[] arr2 = magazine.toCharArray();
    //        Arrays.sort(arr1);
    //        Arrays.sort(arr2);
    //
    //        int i = 0, j = 0;
    //        int len1 = ransomNote.length();
    //        int len2 = magazine.length();
    //
    //        while (i < len1 && j < len2) {
    //            if (arr1[i] == arr2[j]) {
    //                i++;
    //                j++;
    //            } else if (arr1[i] < arr2[j]) {
    //                return false;
    //            } else {
    //                j++;
    //            }
    //        }
    //        return i == len1;
}
