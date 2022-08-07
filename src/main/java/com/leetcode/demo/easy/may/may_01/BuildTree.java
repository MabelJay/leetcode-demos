package com.leetcode.demo.easy.may.may_01;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public static void main(String[] args) {

        // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //输出: [3,9,20,null,null,15,7]

        // [1,2,3]
        //[3,2,1]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = new BuildTree().buildTree(preorder, inorder);
        traverseTree(node);
    }

    public static void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, len - 1, 0);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int preOrderLeft, int preOrderRight, int inorderIndex) {
        if (preOrderLeft > preOrderRight) return null;
        int inRoot = inorderMap.get(preorder[preOrderLeft]);
        int leftSize = inRoot - inorderIndex;
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        root.left = buildTree(preorder, inorderMap, preOrderLeft + 1, preOrderLeft + leftSize, inorderIndex);
        root.right = buildTree(preorder, inorderMap, preOrderLeft + leftSize + 1, preOrderRight, inRoot + 1);
        return root;
    }
}
