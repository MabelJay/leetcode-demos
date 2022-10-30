package com.leetcode.demo.oct.day30;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        // 输入：s = "a1b2"
        //输出：["a1b2", "a1B2", "A1b2", "A1B2"]
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list;
        dfs(s, 0, list, new StringBuilder());
        return list;
    }

    public void dfs(String s, int index, List<String> list, StringBuilder sb) {
        if (index == s.length()) {
            list.add(sb.toString());
            return;
        }

        char tmpChar = s.charAt(index);
        sb.append(tmpChar);
        dfs(s, index + 1, list, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (!Character.isLetter(tmpChar)) return;
        if (Character.isLowerCase(tmpChar)) {
            sb.append(Character.toUpperCase(tmpChar));
        } else {
            sb.append(Character.toLowerCase(tmpChar));
        }
        dfs(s, index + 1, list, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
