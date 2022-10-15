package com.leetcode.demo.oct.day15;

public class SortedArrayToBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：nums = [-10,-3,0,5,9]
        //输出：[0,-3,9,-10,null,5]
        //解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案

        int[] nums = {-10, -3, 0, 5, 9};
        SortedArrayToBST tree = new SortedArrayToBST();
        tree.preTraverse(tree.sortedArrayToBST(nums));
    }

    public void preTraverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int midIndex = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = buildBST(nums, left, midIndex - 1);
        root.right = buildBST(nums, midIndex + 1, right);
        return root;
    }
}
