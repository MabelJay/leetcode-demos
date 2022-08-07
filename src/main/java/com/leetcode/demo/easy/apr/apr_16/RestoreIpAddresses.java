package com.leetcode.demo.easy.apr.apr_16;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    List<String> resList = new ArrayList<>();
    int[] addressArr;
    final int SEG_COUNT = 4;

    public static void main(String[] args) {
        // 输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]

        // 输入：s = "101023"
        //输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        String s = "101023";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        addressArr = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return resList;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(addressArr[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                resList.add(sb.toString());
            }
            return;
        }

        if (segStart == s.length()) return;

        if (s.charAt(segStart) == '0') {
            addressArr[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        int ipAddr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            ipAddr = ipAddr * 10 + s.charAt(segEnd) - '0';
            if (ipAddr > 0 && ipAddr <= 255) {
                addressArr[segId] = ipAddr;
                dfs(s, segId + 1, segEnd + 1);
            } else break;
        }
    }
}
