package com.leetcode.demo.easy.may.may_03;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(3);
        list.add(11);
        list.add(1);
 /*       System.out.println(list);
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, 1));
        Collections.shuffle(list);
        System.out.println(list);*/
        System.out.println(Collections.max(list));
        System.out.println(list.stream().max(Comparator.comparingInt(o -> o)).get());
        Set<String> set = Collections.singleton("12");

        Set<String> set1 = Set.of("23", "25");
        System.out.println(set1);

        Map<Integer, Integer> map = new HashMap<>();

        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        System.out.println(Integer.MIN_VALUE>>>16);
        System.out.println(Integer.MIN_VALUE>>16);
    }
}
