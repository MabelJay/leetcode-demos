package com.leetcode.demo.easy.may.may_11;

import java.util.LinkedList;

public class ValidateStackSequences {

    public static void main(String[] args) {
        // 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        //输出：true

        // 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        //输出：false

        // [2,1,3,0]
        //[1,3,0,2]
        int[] pushed = {2,1,3,0};
        int[] popped = {1,3,0,2};

        // [4,0,1,2,3]
        //[4,2,3,0,1
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        while (pushed[index] != popped[0]) {
            stack.push(pushed[index++]);
        }

        index++;
        for (int i = 1; i < popped.length; i++) {
            if (stack.isEmpty()) {
                while (index < pushed.length && pushed[index] != popped[i]) {
                    stack.push(pushed[index++]);
                }
                index++;
                continue;
            } else {
                if (popped[i] == stack.peek()) stack.pop();
                else {
                    while (index < pushed.length && pushed[index] != popped[i]) {
                        stack.push(pushed[index++]);
                    }
                    index++;
                    if (index > pushed.length) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
