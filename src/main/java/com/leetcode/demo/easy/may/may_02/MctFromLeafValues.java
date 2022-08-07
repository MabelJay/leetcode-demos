package com.leetcode.demo.easy.may.may_02;

import java.util.*;

public class MctFromLeafValues {

    public static void main(String[] args) {
        // 输入：arr = [6,2,4]
        //输出：32
        int[] arr = {6, 2, 4};

        // [7,12,8,10]
        int[] arr2 = {6, 2, 4};

        // [6,15,5,2]
        int[] arr3 = {6, 15, 5, 2};
        System.out.println(new MctFromLeafValues().mctFromLeafValues(arr3));
    }

    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int sum = 0;
        int index = 0;
        while (index < arr.length) {
            while (arr[index] >= stack.peek()) {
                sum += stack.pop() * Math.min(stack.peek(), arr[index]);
            }
            stack.push(arr[index]);
            index++;
        }
        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}
