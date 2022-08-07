package com.leetcode.demo.easy.may.may_03;

public class LemonadeChange {

    public static void main(String[] args) {
        // 输入：bills = [5,5,5,10,20]
        //输出：true

        // 输入：bills = [5,5,10,10,20]
        //输出：false

        int[] bills = {5,5,10,10,20};
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[3];

        for (int bill : bills) {
            if (bill == 5) changes[0]++;
            else if (bill == 10) {
                changes[0]--;
                if (changes[0] < 0) return false;
                changes[1]++;
            } else {
                if (changes[1] > 0) {
                    changes[1]--;
                    changes[0]--;
                } else {
                    changes[0] -= 3;
                }
                if (changes[0] < 0) return false;
            }
        }
        return true;
    }
}
