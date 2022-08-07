package com.leetcode.demo.easy.may.may_18;

public class StrProcess {

    public static void main(String[] args) {
        // ["A", "", "", "", "", "B", "", "", "", "C", "", ""]

        String[] s = {"A", "", "", "", "", "B", "", "", "", "C", "", ""};

        System.out.println(new StrProcess().getIndexOfStr(s, "A"));
        System.out.println(new StrProcess().getIndexOfStr(s, "B"));
        System.out.println(new StrProcess().getIndexOfStr(s, "C"));
        System.out.println(new StrProcess().getIndexOfStr(s, "D"));
    }

    public int getIndexOfStr(String[] arr, String s) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int temp = mid;
            while (arr[mid].equals("")) {
                mid++;
                if (mid > high) {
                    mid = temp;
                    while (arr[mid].equals("")) {
                        mid--;
                        if (mid < low) return -1;
                    }
                }
            }
            if (arr[mid].equals(s)) return mid;
            else if (arr[mid].compareTo(s) > 0) {
                high = temp - 1;
            } else low = temp + 1;
        }
        return -1;
    }
}
