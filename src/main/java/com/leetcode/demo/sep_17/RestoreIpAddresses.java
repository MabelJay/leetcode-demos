package com.leetcode.demo.sep_17;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    private static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];

    public static void main(String[] args) {
        // 输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }

    private List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list;

        dfs(list, s, 0, 0);
        return list;
    }

    public void dfs(List<String> list, String s, int index, int segId) {
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
            dfs(list, s, index + 1, segId + 1);
        }

        int addr = 0;
        for (int segEnd = index; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(list, s, segEnd + 1, segId + 1);
            } else break;
        }
    }
}
