package com.leetcode.demo.easy.dec.dec_27;

public class ToLowerCase {
    public static void main(String[] args) {
        char a = 'a';
        char b = 'A';
        System.out.println((char) (b + 32));
        System.out.println('Z' - 0);

        System.out.println(new ToLowerCase().toLowerCase("Hello@[]"));
    }

    public String toLowerCase(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp < 91 && temp >= 65) {
                temp |= 32;
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
