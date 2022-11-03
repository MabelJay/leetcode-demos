package com.leetcode.demo.sep.day02;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        // 输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(new Partition().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) return list;
        dfs(list, 0, 0, new StringBuilder(), n);
        return list;
    }

    public void dfs(List<String> list, int leftCount, int rightCount, StringBuilder sb, int n) {
        if (leftCount < rightCount || leftCount > n) return;
        if (leftCount == rightCount && leftCount == n) {
            list.add(sb.toString());
            return;
        }

        sb.append("(");
        dfs(list, leftCount + 1, rightCount, sb, n);
        sb.deleteCharAt(sb.length() - 1);
        if (leftCount > rightCount) {
            sb.append(")");
            dfs(list, leftCount, rightCount + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
