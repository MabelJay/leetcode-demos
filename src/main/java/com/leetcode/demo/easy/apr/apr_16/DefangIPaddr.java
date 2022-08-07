package com.leetcode.demo.easy.apr.apr_16;

public class DefangIPaddr {
    public static void main(String[] args) {
        // 输入：address = "1.1.1.1"
        //输出："1[.]1[.]1[.]1"

        // 输入：address = "255.100.50.0"
        //输出："255[.]100[.]50[.]0"

        String s = "255.100.50.0";
        System.out.println(new DefangIPaddr().defangIPaddr(s));
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[").append(".").append("]");
            } else sb.append(address.charAt(i));
        }
        return sb.toString();
    }
}
