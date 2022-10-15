package com.leetcode.demo.oct.day15;

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

        BuildTreeByInAndPostOrder tree = new BuildTreeByInAndPostOrder();
        tree.preTraverse(tree.buildTree(inorder, postorder));
    }

    public void preTraverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        int len = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, inorderMap, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap,
                              int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight) return null;
        TreeNode root = new TreeNode(postorder[postRight]);
        int inIndex = inorderMap.get(root.val);
        int leftSize = inIndex - inLeft;

        root.left = buildTree(postorder, inorderMap, postLeft, postLeft + leftSize - 1,
                inLeft, inIndex - 1);
        root.right = buildTree(postorder, inorderMap, postLeft + leftSize, postRight - 1,
                inIndex + 1, inRight);
        return root;
    }
}
