package com.leetcode.demo.easy.jan.jan_21;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeByInAndPostOrder {

    public static void main(String[] args) {
        // 中序遍历 inorder = [9,3,15,20,7]
        //后序遍历 postorder = [9,15,7,20,3]

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        TreeNode resNode = new BuildTreeByInAndPostOrder().buildTree(inorder, postOrder);
        traverse(resNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        int size = inorder.length;
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(inOrderMap, postorder, 0, size - 1, 0, size - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inOrderMap, int[] postorder, int postOrderLeft, int postOrderRight, int inOrderLeft, int inOrderRight) {
        if (postOrderLeft > postOrderRight) return null;

        int postRoot = postOrderRight;
        int inRoot = inOrderMap.get(postorder[postRoot]);
        TreeNode rootNode = new TreeNode(postorder[postRoot]);

        int rightSize = inOrderRight - inRoot;
        rootNode.right = buildTree(inOrderMap, postorder, postOrderRight - rightSize, postOrderRight - 1, inRoot + 1, inOrderRight);
        rootNode.left = buildTree(inOrderMap, postorder, postOrderLeft, postOrderRight - rightSize - 1, inOrderLeft, inRoot - 1);
        return rootNode;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }
}
