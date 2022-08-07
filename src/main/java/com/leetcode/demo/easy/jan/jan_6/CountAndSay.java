package com.leetcode.demo.easy.jan.jan_6;

public class CountAndSay {

    public static void main(String[] args) {
        String s = "1211";
//        System.out.println(new CountAndSay().describePre(s));
        System.out.println(new CountAndSay().countAndSay3(5));
    }

    public String countAndSay2(int n) {
        String pre = "1";
        String res = "";
        for (int i = 2; i <= n; i++) {
            res = describePre(pre);
            pre = res;
        }
        return pre;
    }

    public String describePre(String s) {
        int count = 1;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < len) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
            i++;
        }
        sb.append(count).append(s.charAt(i - 1));
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        return describePre(countAndSay(n - 1));
    }

    public String countAndSay3(int n) {
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int index = 1;
            while (index < pre.length()) {
                if (pre.charAt(index) == pre.charAt(index - 1)) {
                    count++;
                } else {
                    sb.append(count).append(pre.charAt(index - 1));
                    count = 1;
                }
                index++;
            }
            sb.append(count).append(pre.charAt(index - 1));
            pre = sb.toString();
        }
        return pre;
    }
}
