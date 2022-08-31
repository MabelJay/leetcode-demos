package com.leetcode.demo.aug_31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {
        // 输入：digits = "23"
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String digits = "23";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        if (digits == null || digits.length() == 0) return resList;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(resList, map, 0, digits, new StringBuilder());
        return resList;
    }

    public void backtrack(List<String> resList, Map<Character, String> map, int index, String digits, StringBuilder combination) {
        if (index == digits.length()) {
            resList.add(combination.toString());
            return;
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int letterLen = letters.length();
            for (int i = 0; i < letterLen; i++) {
                combination.append(letters.charAt(i));
                backtrack(resList, map, index + 1, digits, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
