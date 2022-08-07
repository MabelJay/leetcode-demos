package com.leetcode.demo.easy.dec.dec_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {
        //输入：digits = "23"
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String digits = "23";
        char a = '2';
//        System.out.println((int) a);
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr[digits.charAt(i) - 50];
        }
//        System.out.println(Arrays.toString(res));
        backtrack(list, res, digits, 0, new StringBuilder());
        return list;
    }

    public void backtrack(List<String> combinations, String[] phoneArr, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
        } else {
            String letters = phoneArr[index];
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                sb.append(letters.charAt(i));
                System.out.println(sb);
                backtrack(combinations, phoneArr, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }

    public void backtrack2(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack2(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public String getStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (num - 2 + i + 'a'));
        }
        return sb.toString();
    }
}
