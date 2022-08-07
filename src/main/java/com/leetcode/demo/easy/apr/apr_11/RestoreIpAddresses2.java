package com.leetcode.demo.easy.apr.apr_11;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses2 {

    static final int SEG_COUNT = 4;
    List<String> resList = new ArrayList<>();
    int[] addArr;

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses2().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        addArr = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return resList;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(addArr[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                resList.add(sb.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            addArr[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int ip = 0;
        for (int i = segStart; i < s.length(); i++) {
            ip = ip * 10 + s.charAt(i) - '0';
            if (ip > 0 && ip <= 255) {
                addArr[segId] = ip;
                dfs(s, segId + 1, i + 1);
            } else break;
        }
    }
}
