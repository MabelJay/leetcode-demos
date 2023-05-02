package com.leetcode.demo.interview;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeByInAndPostOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        //输出：[3,9,20,null,null,15,7]

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = new BuildTreeByInAndPostOrder().buildTree(inorder, postorder);
        preorder(root);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        int len = postorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(postorder, inMap, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(int[] postorder, Map<Integer, Integer> inMap, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) return null;

        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);

        int leftSize = inIndex - inLeft;
        root.left = buildTree(postorder, inMap, inLeft, inIndex - 1, postLeft, postLeft + leftSize - 1);
        root.right = buildTree(postorder, inMap, inIndex + 1, inRight, postLeft + leftSize, postRight - 1);
        return root;
    }

}
