package com.leetcode.demo.easy.dec.dec_26;


import java.util.ArrayList;
import java.util.List;

public class MyHashSetTest {

    public static void main(String[] args) {
  /*      ArrayList<Integer> list = new ArrayList<>(11);
        System.out.println(list.size());*/
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
