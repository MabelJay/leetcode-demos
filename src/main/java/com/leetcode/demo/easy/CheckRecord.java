package com.leetcode.demo.easy;

public class CheckRecord {

    public static void main(String[] args) {
        // 输入：s = "PPALLP"
        //输出：true

        String s = "PPALLL";
        System.out.println(new CheckRecord().checkRecord(s));
    }

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;
        int absentCount = 0;
        int lateCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') absentCount++;
            if (absentCount == 2) return false;
            if (s.charAt(i) == 'L') {
                lateCount++;
                if (lateCount == 3) return false;
            } else {
                lateCount = 0;
            }
        }
        return true;
    }
}
