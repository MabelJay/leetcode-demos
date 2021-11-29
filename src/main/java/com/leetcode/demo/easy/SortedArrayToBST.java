package com.leetcode.demo.easy;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
//        sortedArrayToBST.sortedArrayToBST(arr);

        System.out.println(sortedArrayToBST.sortedArrayToBST(arr).val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(arr[mid]);
            root.left = buildTree(arr, left, mid - 1);
            root.right = buildTree(arr, mid + 1, right);
            return root;
        }
        return null;
    }
}
