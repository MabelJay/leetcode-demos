package com.leetcode.demo.easy.apr.apr_19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

public class Trap {

    public static void main(String[] args) {
        // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6

        // 输入：height = [4,2,0,3,2,5]
        //输出：9

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap().trap3(height));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(new Trap().trap3(height2));

        Properties properties = System.getProperties();
        System.out.println(properties);
        System.out.println(properties.get("UseAdaptiveSizePolicy"));
    }

    // dp
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    // 单调栈
    public int trap2(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int width = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                ans += width * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    // dp enhancement
    public int trap3(int[] height) {
        int len = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = len - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
