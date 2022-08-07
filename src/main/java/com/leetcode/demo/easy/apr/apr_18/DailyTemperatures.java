package com.leetcode.demo.easy.apr.apr_18;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures {

    public static void main(String[] args) {
        // 输入: temperatures = [73,74,75,71,69,72,76,73]
        //输出: [1,1,4,2,1,1,0,0]
        int[] temperatures = {30, 60, 90};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));

        // 输入: temperatures = [30,40,50,60]
        //输出: [1,1,1,0]

        // 输入: temperatures = [30,60,90]
        //输出: [1,1,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();

        int m = temperatures.length;
        int index = 0;
        int[] res = new int[m];

        while (index < m) {
            while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                int tmpIndex = stack.pop();
                res[tmpIndex] = index - tmpIndex;
            }
            stack.push(index);
            index++;
        }
        return res;
    }
}
