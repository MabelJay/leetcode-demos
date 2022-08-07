package com.leetcode.demo.easy.dec.dec_24;

public class HasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.toBinaryString(3));

        // 输入：n = 11
        //输出：false
        //解释：11 的二进制表示是：1011.
        System.out.println(new HasAlternatingBits().hasAlternatingBits(9));

    }

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int index = 1;
        while (index < len) {

            if ((s.charAt(index) ^ s.charAt(index - 1)) != 1) {
                return false;
            }
            index += 1;
        }
        return true;
    }
}
