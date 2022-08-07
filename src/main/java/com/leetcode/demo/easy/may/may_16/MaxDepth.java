package com.leetcode.demo.easy.may.may_16;

import com.leetcode.demo.easy.TreeNode;

public class MaxDepth {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new MaxDepth().maxDepth(node1));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
    }
}
