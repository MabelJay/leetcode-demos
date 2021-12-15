package com.leetcode.demo.easy;

public class DetectCapitalUse {

    public static void main(String[] args) {
        //全部字母都是大写，比如 "USA" 。
        //单词中所有字母都不是大写，比如 "leetcode" 。
        //如果单词不只含有一个字母，只有首字母大写， 比如 "Google"

        //输入：word = "USA"
        //输出：true

//        System.out.println('a' - 0);
        System.out.println(new DetectCapitalUse().detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) > 96) {
            return word.equals(word.toLowerCase());
        } else {
            if (word.equals(word.toUpperCase())) return true;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 97) return false;
            }
            return true;
        }
    }
}
