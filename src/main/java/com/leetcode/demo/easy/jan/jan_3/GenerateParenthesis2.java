package com.leetcode.demo.easy.jan.jan_3;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis2 {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis2().generateParenthesis2(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        getParenthesis(new StringBuilder(), list, 0, 0, n);
        return list;
    }

    public void getParenthesis(StringBuilder sb, List<String> list, int open, int close, int max) {
        if (sb.length() == 2 * max) {
            list.add(sb.toString());
            return;
        }

        if (open < max) {
            getParenthesis(sb.append('('), list, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            getParenthesis(sb.append(')'), list, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        getParenthesis2(new StringBuilder(), list, n, n);
        return list;
    }

    public void getParenthesis2(StringBuilder sb, List<String> list, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(sb.toString());
            return;
        }

        if (left == right) {
            getParenthesis2(sb.append('('), list, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis2(sb.append('('), list, left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            getParenthesis2(sb.append(')'), list, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
