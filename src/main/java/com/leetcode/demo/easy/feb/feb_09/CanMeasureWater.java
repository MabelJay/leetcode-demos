package com.leetcode.demo.easy.feb.feb_09;

public class CanMeasureWater {
    public static void main(String[] args) {
        // 输入: x = 3, y = 5, z = 4
        //输出: True

        // 6
        //9
        //1

        // 34
        //5
        //6

        System.out.println(new CanMeasureWater().canMeasureWater(34, 5, 6));
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        else if (jug1Capacity == 0 || jug2Capacity == 0)
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    public int gcd(int x, int y) {
        int reminder = x % y;
        while (reminder != 0) {
            x = y;
            y = reminder;
            reminder = x % y;
        }
        return y;
    }
}
