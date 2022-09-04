package com.leetcode.demo.sep_04;

public class CountAndSay {

    public static void main(String[] args) {
        // 输入：n = 4
        //输出："1211"
        System.out.println(new CountAndSay().countAndSay2(5));
    }

    public String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuilder preStr = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < preStr.length()) {
                int count = 0;
                if (j == 0 || (j > 0 && preStr.charAt(j) != preStr.charAt(j - 1))) {
                    count++;
                    j++;
                }
                while (j < preStr.length() && j > 0 && preStr.charAt(j) == preStr.charAt(j - 1)) {
                    count++;
                    j++;
                }
                sb.append(count).append(preStr.charAt(j - 1));
            }
            preStr = sb;
        }
        return preStr.toString();
    }

    public String countAndSay2(int n) {
        if (n <= 0) return "";
        String str = "1";
        for (int i = 2; i <= n; i++) {
            int start = 0, curPos = 0;
            StringBuilder sb = new StringBuilder();
            while (curPos < str.length()) {
                while (curPos < str.length() && str.charAt(curPos) == str.charAt(start)) {
                    curPos++;
                }
                sb.append(curPos - start).append(str.charAt(start));
                start = curPos;
            }
            str = sb.toString();
        }
        return str;
    }
}
