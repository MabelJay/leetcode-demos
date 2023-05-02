package com.leetcode.demo.apr.day20;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private List<String> list;

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if (n < 1) return list;
        getParenthesis(n, 0, 0, new StringBuilder());
        return list;
    }

    private void getParenthesis(int n, int leftCount, int rightCount, StringBuilder sb) {
        if (rightCount > leftCount || leftCount > n) return;

        if (leftCount == rightCount && leftCount == n) {
            list.add(sb.toString());
        }

        sb.append("(");
        getParenthesis(n, leftCount + 1, rightCount, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (leftCount > rightCount) {
            sb.append(")");
            getParenthesis(n, leftCount, rightCount + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
