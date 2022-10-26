package com.leetcode.demo.oct.day26;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        // 输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]
        //输入：n = 1
        //输出：["()"]
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;

        getAllParenthesis(n, list, new StringBuilder(), 0, 0);
        return list;
    }

    public void getAllParenthesis(int n, List<String> list, StringBuilder sb, int leftCount, int rightCount) {
        if (rightCount > leftCount) return;
        if (leftCount == n && leftCount == rightCount) {
            list.add(sb.toString());
            return;
        }
        if (leftCount < n) {
            sb.append("(");
            getAllParenthesis(n, list, sb, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");
        getAllParenthesis(n, list, sb, leftCount, rightCount + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
