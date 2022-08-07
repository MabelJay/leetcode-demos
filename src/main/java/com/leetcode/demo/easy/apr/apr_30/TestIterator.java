package com.leetcode.demo.easy.apr.apr_30;

import java.util.*;

public class TestIterator {

    public static void main(String[] args) {
        new TestIterator().testList();
    }

    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("world2");

//        Iterator<String> iterator = list.iterator();
        System.out.println(list);
        list.forEach(obj -> System.out.println(obj));
        list.stream().forEach(System.out::println);
        list.forEach(System.out::println);
    }

    public void testCollection() {
        Set<String> c = new HashSet();
        c.add("12");
        c.add("23");

        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            String val = iterator.next();
            if (val.equals("12")) {
                iterator.remove();
            }
        }
        System.out.println(c);
    }
}
