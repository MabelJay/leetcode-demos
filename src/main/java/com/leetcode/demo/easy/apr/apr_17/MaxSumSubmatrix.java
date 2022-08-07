package com.leetcode.demo.easy.apr.apr_17;

import java.util.TreeSet;

public class MaxSumSubmatrix {
    public static void main(String[] args) {
        // 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
        //输出：2
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix(matrix, 2));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
