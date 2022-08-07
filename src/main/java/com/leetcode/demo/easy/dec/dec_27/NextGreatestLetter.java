package com.leetcode.demo.easy.dec.dec_27;

public class NextGreatestLetter {

    public static void main(String[] args) {
        // letters = ["c", "f", "j"]
        //target = "a"
        //输出: "c"

        // ["e","e","e","e","e","e","n","n","n","n"]
        // 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'

        char[] letters = {'c', 'f', 'j'};
        System.out.println(new NextGreatestLetter().nextGreatestLetter3(letters, 'j'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) return ' ';
        int len = letters.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] == target) {
                if (mid < len - 1 && letters[mid + 1] > target) return letters[mid + 1];
                low = mid + 1;
            } else if (letters[mid] > target) {
                if (mid - 1 >= 0 && letters[mid - 1] < target) return letters[mid];
                high = mid - 1;
            } else {
                if (mid < len - 1 && letters[mid + 1] > target) return letters[mid + 1];
                low = mid + 1;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        if (letters == null || letters.length == 0) return ' ';
        int len = letters.length;
        if (target < letters[0] || target > letters[len - 1]) return letters[0];
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }

    public char nextGreatestLetter3(char[] letters, char target) {
        if (letters == null || letters.length == 0) return ' ';
        int low = 0, high = letters.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low % letters.length];
    }
}
