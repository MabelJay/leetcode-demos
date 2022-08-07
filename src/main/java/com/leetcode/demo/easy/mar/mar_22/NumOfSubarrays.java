package com.leetcode.demo.easy.mar.mar_22;

import java.util.List;

public class NumOfSubarrays {

    public int count = 0;

    public static void main(String[] args) {
        // 输入：arr = [1,3,5]
        //输出：4
        //解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
        //所有子数组的和为 [1,4,9,3,8,5].
        //奇数和包括 [1,9,3,5] ，所以答案为 4 。
        int[] arr = {1, 3, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr3 = {100, 100, 99, 99};
        System.out.println(new NumOfSubarrays().numOfSubarrays(arr));
        System.out.println(new NumOfSubarrays().numOfSubarrays(arr2));
        System.out.println(new NumOfSubarrays().numOfSubarrays(arr3));

    }

    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1000000007;
        int even = 1, odd = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            count = (count + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else odd++;
        }
        return count;
    }

    public void dfs(int[] arr, int index, int sum) {
        if (index == arr.length) {
            if (sum % 2 != 0) {
                count++;
            }
            return;
        }
        sum += arr[index];
        dfs(arr, index + 1, sum);
        sum -= arr[index];
        dfs(arr, index + 1, sum);
    }
}
