package com.leetcode.demo.easy.may.may_18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringOutput {

    List<String> list;
    Set<String> set;

    public static void main(String[] args) {
        // {
        //"MORGAN",
        //"STANLEY",
        //"INTERNATIONAL",
        //"BANK"
        //}
        //output："MSIB", "MSIA","MSIN","MSIK","MSNB"

        String[] arr = {"MORGAN", "STANLEY", "INTERNATIONAL", "BANK"};
        System.out.println(new StringOutput().getAllStr(arr));
    }

    public List<String> getAllStr(String[] strArr) {
        list = new ArrayList<>();
        set = new HashSet<>();
        if (strArr == null || strArr.length == 0) return list;
        dfs(strArr, 0, new StringBuilder());
        System.out.println("list size=" + list.size());
        list.stream().forEach(num -> set.add(num));
        System.out.println("set size=" + set.size());
        return list;
    }

    public void dfs(String[] arr, int index, StringBuilder sb) {
        if (index == arr.length) {
            if (sb.length() == arr.length) list.add(sb.toString());
            return;
        }

        String str = arr[index];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(arr, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
