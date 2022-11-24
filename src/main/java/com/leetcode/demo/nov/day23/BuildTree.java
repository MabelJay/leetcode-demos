package com.leetcode.demo.nov.day23;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    private static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        new BuildTree().dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        int len = preorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorderMap, preorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inorderMap, int[] preorder, int preLeft,
                              int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int inIndex = inorderMap.get(preorder[preLeft]);
        int leftSize = inIndex - inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTree(inorderMap, preorder, preLeft + 1, preLeft + leftSize, inLeft, inRight - 1);
        root.right = buildTree(inorderMap, preorder, preLeft + leftSize + 1, preRight, inIndex + 1, inRight);
        return root;
    }
}
