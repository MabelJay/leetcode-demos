package com.leetcode.demo.easy.june.june_18;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;

        getParenthesis(n, 0, 0, list, new StringBuilder());
        return list;
    }

    public void getParenthesis(int n, int leftCount, int rightCount, List<String> list, StringBuilder sb) {
        if (rightCount > leftCount || leftCount > n) return;

        if (leftCount == n && rightCount == n) {
            list.add(sb.toString());
            return;
        }

        sb.append("(");
        getParenthesis(n, leftCount + 1, rightCount, list, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (leftCount > rightCount) {
            sb.append(")");
            getParenthesis(n, leftCount, rightCount + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
