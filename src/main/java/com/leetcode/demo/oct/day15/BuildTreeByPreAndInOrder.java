package com.leetcode.demo.oct.day15;

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
        // 输入: preorder = [3,9,20,15,7  ], inorder = [9,3,15,20,7]
        //输出: [3,9,20,null,null,15,7]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTreeByPreAndInOrder tree = new BuildTreeByPreAndInOrder();
        tree.preorderTraverse(tree.buildTree(preorder, inorder));
    }

    public void preorderTraverse(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        int len = preorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
                              int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorderIndex = inorderMap.get(root.val);
        int leftSize = inorderIndex - inLeft;
        root.left = buildTree(preorder, inorderMap, preLeft + 1,
                preLeft + leftSize, inLeft, inorderIndex - 1);
        root.right = buildTree(preorder, inorderMap, preLeft + leftSize + 1, preRight,
                inorderIndex + 1, inRight);
        return root;
    }
}
