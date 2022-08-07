package com.leetcode.demo.easy.apr.apr_02;

import java.util.LinkedList;

public class MaximumGain {

    public static void main(String[] args) {
        // 输入：s = "cdbcbbaaabab", x = 4, y = 5
        //输出：19
        // 删除子字符串ab"并得到 x 分。
        //比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
        //删除子字符串"ba" 并得到 y 分。
        //比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。

        String s = "aabbaaxybbaabb";
        System.out.println(new MaximumGain().maximumGain(s, 5, 4));
        // 输入：s = "aabbaaxybbaabb", x = 5, y = 4
        //输出：20

    }

    public int maximumGain(String s, int x, int y) {
        int[] countX = new int[1];
        int[] countY = new int[1];
        StringBuilder sb;
        if (x > y) {
            sb = delStr(s, countX);
            delStr(sb.reverse().toString(), countY);
        } else {
            sb = new StringBuilder(s);
            sb = delStr(sb.reverse().toString(), countY);
            System.out.println(sb);
            delStr(sb.reverse().toString(), countX);
        }
        return countX[0] * x + countY[0] * y;
    }

    public StringBuilder delStr(String s, int[] count) {
        if (s.length() == 0) return new StringBuilder();
        int countSum = count[0];
        LinkedList<Character> stack = new LinkedList<>();
        int index = 1, len = s.length();
        stack.push(s.charAt(0));
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        while (index < len) {
            if (!stack.isEmpty() && s.charAt(index) == 'b' && stack.peek() == 'a') {
                stack.pop();
                countSum++;
                res.deleteCharAt(res.length() - 1);
            } else {
                stack.push(s.charAt(index));
                res.append(s.charAt(index));
            }
            index++;
        }
        count[0] = countSum;
        return res;
    }
}
