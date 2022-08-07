package com.leetcode.demo.easy.apr.apr_03;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        // 输入：s = "a1b2"
        //输出：["a1b2", "a1B2", "A1b2", "A1B2"]

        String s = "a1b2";
        String s2 = "3z4";
        System.out.println(new LetterCasePermutation().letterCasePermutation(s));
        System.out.println(new LetterCasePermutation().letterCasePermutation(s2));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        dfs(list, s, 0, new StringBuilder());
        return list;
    }

    public void dfs(List<String> res, String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            if (sb.length() == s.length()) {
                res.add(sb.toString());
            }
            return;
        }

        sb.append(s.charAt(index));
        dfs(res, s, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (Character.isLetter(s.charAt(index))) {
            if (Character.isUpperCase(s.charAt(index))) {
                sb.append(Character.toLowerCase(s.charAt(index)));
            } else {
                sb.append(Character.toUpperCase(s.charAt(index)));
            }
            dfs(res, s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
