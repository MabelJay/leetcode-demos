package com.leetcode.demo.easy.dec.dec_28;

import java.util.Arrays;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        // 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
        //输出："steps

        String[] strings = {"step", "steps", "stripe", "stepple"};
        String word = "1s3 PSt";

        System.out.println(new ShortestCompletingWord().shortestCompletingWord(word, strings));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseArr = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char temp = licensePlate.charAt(i);
            if (Character.isLetter(temp)) {
                licenseArr[Character.toLowerCase(temp) - 'a']++;
            }
        }

        int index = -1;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            int[] arrTemp = new int[26];
            for (int j = 0; j < temp.length(); j++) {
                char tempChar = temp.charAt(j);
                arrTemp[tempChar - 'a']++;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (arrTemp[j] < licenseArr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag && (index < 0 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        return words[index];
    }
}
