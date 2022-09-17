package com.leetcode.demo.sep_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationOfStr {

    boolean[] visited;

    public static void main(String[] args) {
        // 输入：s = "abc"
        //输出：["abc","acb","bac","bca","cab","cba"]

        String s = "aab";
        String s1 = "kzfxxx";
        System.out.println(Arrays.toString(new PermutationOfStr().permutation(s)));
    }

    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list.toArray(new String[0]);

        int n = s.length();
        visited = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        dfs(list, arr, 0, sb, n);
        return list.toArray(new String[0]);
    }

    public void dfs(List<String> list, char[] arr, int index, StringBuilder sb, int len) {
        if (index == len) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && arr[i] == arr[i - 1])) continue;
            visited[i] = true;
            sb.append(arr[i]);
            dfs(list, arr, index + 1, sb, len);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
