package com.leetcode.demo.nov.day16;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        // 输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;

        dfs(list, new StringBuilder(), n, 0, 0);
        return list;
    }

    public void dfs(List<String> list, StringBuilder sb, int n, int leftCount, int rightCount) {
        if (rightCount > leftCount || leftCount > n) return;
        if (leftCount == rightCount && leftCount == n) {
            list.add(sb.toString());
            return;
        }

        sb.append("(");
        dfs(list, sb, n, leftCount + 1, rightCount);
        sb.deleteCharAt(sb.length() - 1);

        if (leftCount > rightCount) {
            sb.append(")");
            dfs(list, sb, n, leftCount, rightCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
