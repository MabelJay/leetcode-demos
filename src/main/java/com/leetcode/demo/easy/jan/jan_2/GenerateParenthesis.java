package com.leetcode.demo.easy.jan.jan_2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        // 输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]

        System.out.println(new GenerateParenthesis().generateParenthesis3(3));
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        generateAll2(new char[2 * n], 0, list);
        return list;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void generateAll2(char[] arr, int pos, List<String> list) {
        if (pos == arr.length) {
            if (valid(arr)) {
                list.add(new String(arr));
            }
        } else {
            arr[pos] = '(';
            generateAll2(arr, pos + 1, list);
            arr[pos] = ')';
            generateAll2(arr, pos + 1, list);
        }
    }

    public boolean valid(char[] cur) {
        int leftSum = 0;
        for (char c : cur) {
            if (c == '(') {
                leftSum++;
            } else {
                leftSum--;
            }
            if (leftSum < 0) return false;
        }
        return leftSum == 0;
    }

    public void generate(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == 2 * max) {
            list.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            generate(list, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            generate(list, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis3(int n) {
        if (n <= 0) return ans;
        getParenthesis(new StringBuilder(), n, n);
        return ans;
    }

    public void getParenthesis(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }
        if (left == right) {
            sb.append('(');
            getParenthesis(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(sb.append('('), left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            getParenthesis(sb.append(')'), left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
