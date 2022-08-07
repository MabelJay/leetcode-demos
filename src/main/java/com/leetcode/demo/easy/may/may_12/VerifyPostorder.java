package com.leetcode.demo.easy.may.may_12;

import java.util.HashMap;
import java.util.Map;

public class VerifyPostorder {

    public static void main(String[] args) {
        // 输入: [1,6,3,2,5]
        //输出: false

        // 输入: [1,3,2,6,5]
        //输出: true

        // [4, 8, 6, 12, 16, 14, 10]
        // true

        // [1,2,5,10,6,9,4,3]
        int[] postorder = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(new VerifyPostorder().verifyPostorder2(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;

        int startIndex = 0;
        if (postorder[0] > postorder[1]) {
            startIndex = 1;
        }

        boolean flag = true;
        while (startIndex < postorder.length) {
            if (startIndex == postorder.length - 1) return true;
            else if (flag && postorder[startIndex] > postorder[startIndex + 1]) return false;
            else if (!flag && postorder[startIndex] < postorder[startIndex + 1]) return false;
            flag = !flag;
            startIndex++;
        }
        return true;
    }

    public boolean verifyPostorder2(int[] postorder) {
        if (postorder.length < 2) return true;
        return dfs(postorder, postorder.length - 1, 0);
    }

    public boolean dfs(int[] postorder, int index, int startIndex) {
        if (index == postorder.length || index < 0) return true;

        if (startIndex >= index) return true;
        int i = startIndex;
        for (; i < index; i++) {
            if (postorder[i] > postorder[index]) break;
        }

        for (int j = i; j < index; j++) {
            if (postorder[j] < postorder[index]) return false;
        }
        boolean left = dfs(postorder, i - 1, startIndex);
        boolean right = dfs(postorder, index - 1, i);
        return left && right;
    }
}
