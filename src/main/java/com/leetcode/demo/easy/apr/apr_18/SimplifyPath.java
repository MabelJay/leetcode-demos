package com.leetcode.demo.easy.apr.apr_18;

import java.util.*;

public class SimplifyPath {

    public static void main(String[] args) {
        // 输入：path = "/home/"
        //输出："/home"
        //解释：注意，最后一个目录名后面没有斜杠。

        // "/."
        // /
        String path = "/a/./b/../../c/";
        System.out.println(new SimplifyPath().simplifyPath(path));

        // 输入：path = "/home//foo/"
        //输出："/home/foo"
        //解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

        // 输入：path = "/a/./b/../../c/"
        //输出："/c"
        // 输入：path = "/../"
        // /

        // "/.."
    }

    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        LinkedList<String> stack = new LinkedList<>();

        for (String str : arr) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();
            } else if (!str.equals(".") && str.length() > 0) {
                stack.offerLast(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.poll());
            }
        }
        return sb.toString();
    }

    public String simplifyPath2(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new LinkedList<>();
        System.out.println(Arrays.toString(arr));

        for (String str : arr) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();
            } else if (!str.equals(".") && str.length() > 0) {
                stack.offerLast(str);
            }
        }

        System.out.println("peek in stack=" + stack.peek());
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }
        return sb.toString();
    }
}
