package com.leetcode.demo.easy.apr.apr_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationStr {

    List<String> list = new ArrayList<>();
    boolean[] visited;

    public static void main(String[] args) {
        // 输入：s = "abc"
        //输出：["abc","acb","bac","bca","cab","cba"]
        String s = "aab";
        System.out.println(Arrays.toString(new PermutationStr().permutation(s)));
    }

    public String[] permutation(String s) {
        int len = s.length();
        visited = new boolean[len];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        backtrace(arr, 0, len, sb);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void backtrace(char[] arr, int index, int len, StringBuilder sb) {
        if (index == len) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && arr[i - 1] == arr[i])) continue;
            visited[i] = true;
            sb.append(arr[i]);
            backtrace(arr, index + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
