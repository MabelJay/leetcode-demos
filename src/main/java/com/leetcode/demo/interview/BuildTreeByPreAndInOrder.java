package com.leetcode.demo.interview;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeByPreAndInOrder {

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
        TreeNode root = new BuildTreeByPreAndInOrder().buildTree(preorder, inorder);
        preorder(root);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

        int len = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        int value = preorder[preLeft];
        TreeNode root = new TreeNode(value);
        int inIndex = inorderMap.get(value);

        int leftLen = inIndex - inLeft;
        root.left = buildTree(preorder, inorderMap, preLeft + 1, preLeft + leftLen, inLeft, inIndex - 1);
        root.right = buildTree(preorder, inorderMap, preLeft + leftLen + 1, preRight, inIndex + 1, inRight);
        return root;
    }
}
