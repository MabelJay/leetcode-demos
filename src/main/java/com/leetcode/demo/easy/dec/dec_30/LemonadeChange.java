package com.leetcode.demo.easy.dec.dec_30;

public class LemonadeChange {

    public static void main(String[] args) {
        // 输入：bills = [5,5,5,10,20]
        //输出：true

        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int changeFive = 0, changeTen = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                changeFive++;
            } else if (bills[i] == 10) {
                changeTen++;
                if (changeFive >= 1) {
                    changeFive--;
                } else return false;
            } else if (bills[i] == 20) {
                if (changeFive == 0) return false;
                int total = changeFive * 5 + changeTen * 10;
                if (total >= 15) {
                    changeFive--;
                    if (changeTen >= 1) {
                        changeTen--;
                    } else {
                        changeFive -= 2;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
