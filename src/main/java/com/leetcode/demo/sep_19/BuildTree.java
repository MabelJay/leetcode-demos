package com.leetcode.demo.sep_19;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        preorderTraverse(root);
    }

    private static void preorderTraverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, preorder.length - 1,
                0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int preorderLeft, int preorderRight,
                              int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) return null;
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int inorderIndex = inorderMap.get(root.val);
        int leftSize = inorderIndex - inorderLeft;
        root.left = buildTree(preorder, inorderMap, preorderLeft + 1,
                preorderLeft + leftSize, inorderLeft, inorderIndex - 1);
        root.right = buildTree(preorder, inorderMap,
                preorderLeft + leftSize + 1, preorderRight, inorderIndex + 1, inorderRight);
        return root;
    }
}
