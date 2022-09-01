package com.leetcode.demo.sep_01;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;

        getParenthesis(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void getParenthesis(List<String> list, StringBuilder combination, int leftCount, int rightCount, int n) {
        if (rightCount > leftCount || leftCount > n) return;

        if (leftCount == rightCount && rightCount == n) {
            list.add(combination.toString());
            return;
        }

        combination.append("(");
        getParenthesis(list, combination, leftCount + 1, rightCount, n);
        combination.deleteCharAt(combination.length() - 1);
        if (leftCount > rightCount) {
            combination.append(")");
            getParenthesis(list, combination, leftCount, rightCount + 1, n);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
