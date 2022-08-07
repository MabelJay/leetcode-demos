package com.leetcode.demo.easy.apr.apr_28;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
    static {
        System.out.println("executing initialing method");
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("12", null);
        System.out.println(map.get("1"));
        System.out.println(map.get("12"));
    }
}
