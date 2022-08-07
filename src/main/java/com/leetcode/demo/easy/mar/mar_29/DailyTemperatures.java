package com.leetcode.demo.easy.mar.mar_29;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures {

    public static void main(String[] args) {
        // 输入: temperatures = [73,74,75,71,69,72,76,73]
        //输出: [1,1,4,2,1,1,0,0]

        //输入: temperatures = [30,40,50,60]
        //输出: [1,1,1,0]

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures2)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int index = 1;
        int len = temperatures.length;
        int[] res = new int[len];
        while (!stack.isEmpty() && index < len) {
            int curVal = temperatures[index];
            while (!stack.isEmpty() && temperatures[stack.peek()] < curVal) {
                int preIndex = stack.pop();
                res[preIndex] = index - preIndex;
            }
            stack.push(index);
            index++;
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
