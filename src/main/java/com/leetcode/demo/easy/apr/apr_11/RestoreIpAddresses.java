package com.leetcode.demo.easy.apr.apr_11;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> resList = new ArrayList<>();
    static final int SEG_COUNT = 4;
    int[] segArr;

    public static void main(String[] args) {
        // 输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]

        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        segArr = new int[SEG_COUNT];
        constructIp(s, 0, 0);
        return resList;
    }

    public void constructIp(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segArr[i]);
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
            segArr[segId] = 0;
            constructIp(s, segId + 1, segStart + 1);
        }
        int ipAddr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            ipAddr = ipAddr * 10 + s.charAt(segEnd) - '0';
            if (ipAddr > 0 && ipAddr <= 255) {
                segArr[segId] = ipAddr;
                constructIp(s, segId + 1, segEnd + 1);
            } else break;
        }
    }
}
