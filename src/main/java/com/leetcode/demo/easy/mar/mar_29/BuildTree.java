package com.leetcode.demo.easy.mar.mar_29;

import com.leetcode.demo.easy.TreeNode;

import java.util.*;

public class BuildTree {

    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        new BuildTree().levelTraverseOfTree(root);
    }

    public void levelTraverseOfTree(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            System.out.print(tmpNode.val + " ");
            if (tmpNode.left != null) queue.offer(tmpNode.left);
            if (tmpNode.right != null) queue.offer(tmpNode.right);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preOrder, Map<Integer, Integer> inOrder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) return null;
        int inRoot = inOrder.get(preOrder[preorderLeft]);

        TreeNode rootNode = new TreeNode(preOrder[preorderLeft]);
        int leftSize = inRoot - inorderLeft;
        rootNode.left = buildTree(preOrder, inOrder, preorderLeft + 1, preorderLeft + leftSize, inorderLeft, inRoot - 1);
        rootNode.right = buildTree(preOrder, inOrder, preorderLeft + leftSize + 1, preorderRight, inRoot + 1, inorderRight);
        return rootNode;
    }
}
