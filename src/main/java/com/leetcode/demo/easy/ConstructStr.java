package com.leetcode.demo.easy;

import java.util.*;

public class ConstructStr {

    public static void main(String[] args) {
        // "aab"
        //"baa"

        //"bg"
        //"efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"

        // "fihjjjjei"
        //"hjibagacbhadfaefdjaeaebgi"

        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.println(new ConstructStr().canConstruct4(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < magazine.length(); i++) {
            list.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!list.contains(ransomNote.charAt(i))) return false;
            list.remove(Character.valueOf(ransomNote.charAt(i)));
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 97;
            arr[index] = arr[index] + 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 97;
            if (arr[index] >= 1) {
                arr[index] = arr[index] - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (map.containsKey(temp)) {
                int count = map.get(temp);
                if (count < 1) {
                    return false;
                } else {
                    map.put(temp, count - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct4(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;

        char[] arr1 = ransomNote.toCharArray();
        char[] arr2 = magazine.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        int len1 = ransomNote.length();
        int len2 = magazine.length();

        while (i < len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                return false;
            } else {
                j++;
            }
        }
        return i == len1;
    }
}
