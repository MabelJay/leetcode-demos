package com.leetcode.demo.sep_17;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddr {

    private static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddr().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list;

        dfs(list, 0, 0, s);
        return list;
    }

    public void dfs(List<String> list, int segId, int index, String s) {
        if (segId == SEG_COUNT) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int val : segments) {
                    sb.append(val).append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                list.add(sb.toString());
            }
            return;
        }
        if (index == s.length()) return;

        if (s.charAt(index) == '0') {
            segments[segId] = 0;
            dfs(list, segId + 1, index + 1, s);
        } else {
            int addr = 0;
            for (int segEnd = index; segEnd < s.length(); segEnd++) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                if (addr > 0 && addr <= 255) {
                    segments[segId] = addr;
                    dfs(list, segId + 1, segEnd + 1, s);
                }
            }
        }
    }
}
