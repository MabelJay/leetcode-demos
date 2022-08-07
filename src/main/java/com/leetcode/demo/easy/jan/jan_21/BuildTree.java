package com.leetcode.demo.easy.jan.jan_21;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode resNode = new BuildTree().buildTree(preorder, inorder);
        traverse(resNode);
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(inOrderMap, preorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inOrderMap, int[] preorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) return null;
        int preRoot = preOrderLeft;
        int inRoot = inOrderMap.get(preorder[preRoot]);

        TreeNode rootNode = new TreeNode(preorder[preRoot]);
        int leftSize = inRoot - inOrderLeft;
        rootNode.left = buildTree(inOrderMap, preorder, preOrderLeft + 1, preOrderLeft + leftSize, inOrderLeft, inRoot - 1);

        rootNode.right = buildTree(inOrderMap, preorder, preOrderLeft + leftSize + 1, preOrderRight, inRoot + 1, inOrderRight);

        return rootNode;
    }
}
