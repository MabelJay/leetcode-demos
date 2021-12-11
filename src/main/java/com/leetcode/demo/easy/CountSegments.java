package com.leetcode.demo.easy;

public class CountSegments {

    public static void main(String[] args) {
        // 输入: "Hello, my name is John"
        // "love live! mu'sic forever"
        //输出: 5

        ///", , , ,        a, eaefa"
        //"The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged."
        System.out.println('A' - 0);
        System.out.println('a' - 0);
        System.out.println('z' - 'A');
        System.out.println(new CountSegments().countSegments2(", , , ,        a, eaefa"));
    }

    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int index = 0;
        int count = 0;
        while (index < len) {
            while (index < len && validChar(s.charAt(index))) {
                index++;
            }
            if (index <= len && index > 0) {
                count++;
            }
            while (index < len && !validChar(s.charAt(index))) {
                index++;
            }
        }
        return count;
    }

    public boolean validChar(char c) {
        int val = c - 'A';
        return (val >= 0 && val <= 57) || c == '\'' || c == '-';
    }

    public int countSegments2(String s) {
        if (s == null || s.length() == 0) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
