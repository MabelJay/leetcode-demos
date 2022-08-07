package com.leetcode.demo.easy.may.may_28;

public class MaxProduct {

    public static void main(String[] args) {
        // 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
        //输出: 16

        // 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
        //输出: 4
        //解释: 这两个单词为 "ab", "cd"。

        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(new MaxProduct().maxProduct(words));
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        boolean[][] arr = new boolean[len][26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int temp = word.charAt(j) - 'a';
                arr[i][temp] = true;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!containsCommon(arr[i], words[j])) maxLen = Math.max(words[i].length() * words[j].length(), maxLen);
            }
        }
        return maxLen;
    }

    public boolean containsCommon(boolean[] arr, String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index]) return true;
        }
        return false;
    }

    public void printMatrix(boolean[][] matrix) {
        for (boolean[] booleans : matrix) {
            for (int j = 0; j < booleans.length; j++) {
                System.out.print(booleans[j] + " ");
            }
            System.out.println();
        }
    }
}
