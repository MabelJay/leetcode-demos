package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        // answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
        //answer[i] == "Fizz" 如果 i 是 3 的倍数。
        //answer[i] == "Buzz" 如果 i 是 5 的倍数。
        //answer[i] == i （以字符串形式）如果上述条件全不满足。
        System.out.println(new FizzBuzz().fizzBuzz2(3));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 != 0) {
                    list.add("Buzz");
                } else if (i % 5 != 0) {
                    list.add("Fizz");
                } else {
                    list.add("FizzBuzz");
                }
            } else {
                list.add("" + i);
            }
        }
        return list;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) return list;

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            if (sb.length() == 0) {
                sb.append(i);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
