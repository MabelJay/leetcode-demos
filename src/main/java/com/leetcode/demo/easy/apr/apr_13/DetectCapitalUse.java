package com.leetcode.demo.easy.apr.apr_13;

public class DetectCapitalUse {
    public static void main(String[] args) {
        // 输入：word = "USA"
        //输出：true

        String word = "ffffffffffffffffffffF";

        // "ffffffffffffffffffffF"
        System.out.println(new DetectCapitalUse().detectCapitalUse(word));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) return true;
        else {
            if (Character.isUpperCase(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) return false;
                }
            } else return word.toLowerCase().equals(word);
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        if (Character.isLowerCase(word.charAt(0))) {
            return word.toLowerCase().equals(word);
        } else {
            if (word.equals(word.toUpperCase())) return true;
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    //  if (word.charAt(0) > 96) {
    //            return word.equals(word.toLowerCase());
    //        } else {
    //            if (word.equals(word.toUpperCase())) return true;
    //            for (int i = 1; i < word.length(); i++) {
    //                if (word.charAt(i) < 97) return false;
    //            }
    //            return true;
    //        }
}
