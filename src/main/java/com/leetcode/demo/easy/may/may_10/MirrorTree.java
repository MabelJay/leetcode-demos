package com.leetcode.demo.easy.may.may_10;

import com.leetcode.demo.easy.TreeNode;

public class MirrorTree {

    public static void main(String[] args) {
        // 输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;


        // 输入：root = [2,1,3]
        //输出：[2,3,1]

        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(3);
        node7.left = node8;
        node7.right = node9;
        TreeNode node = new MirrorTree().mirrorTree(node7);
        new MirrorTree().traverseTree(node);
    }

    public void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        dfs(root.left);
        dfs(root.right);
    }
}
