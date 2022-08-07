package com.leetcode.demo.easy;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(100);
        list.add("Peter");
        list.add("Tom");
        list.add("Mike");
        list.add("Tim");

//        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> sortedStudentList = new LinkedList<>();
        sortedStudentList.add("Peter");
        sortedStudentList.add("Tom");
        sortedStudentList.add("Mike");
        sortedStudentList.add("Tim");
        sortedStudentList.add("Pim");
        sortedStudentList.add("Adalina");

        Comparator<String> comparator = (o1, o2) -> (o1.charAt(0) - o2.charAt(0));
        Collections.sort(sortedStudentList, comparator);
        System.out.println(sortedStudentList);

        Iterator<String> iterator1 = sortedStudentList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
