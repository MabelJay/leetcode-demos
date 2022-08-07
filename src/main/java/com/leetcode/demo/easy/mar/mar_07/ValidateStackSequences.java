package com.leetcode.demo.easy.mar.mar_07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidateStackSequences {

    public static void main(String[] args) {
        // 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        //输出：true

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        // 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        //输出：false
        int[] popped2 = {4, 3, 5, 1, 2};
        System.out.println(new ValidateStackSequences().validateStackSequences2(pushed, popped2));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i], new int[]{i, 0});
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int endIndex = map.get(popped[0])[0];
        for (int i = 0; i <= endIndex; i++) {
            stack.push(pushed[i]);
        }

        int preIndex = -1;
        for (int i = 0; i < pushed.length; ) {
            if (stack.contains(popped[i])) {
                if (stack.peek() == popped[i]) {
                    int val = stack.pop();
                    int[] tmp = map.get(val);
                    tmp[1] = 1;
                    map.put(val, tmp);
                    preIndex = tmp[0];
                    i++;
                } else return false;
            } else {
                int tmpIndex = map.get(popped[i])[0];
                for (int j = preIndex + 1; j <= tmpIndex; j++) {
                    if (map.get(pushed[j])[1] != 1) {
                        stack.push(pushed[j]);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int len = popped.length;
        int j = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && j < len && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return j == len;
    }
}
