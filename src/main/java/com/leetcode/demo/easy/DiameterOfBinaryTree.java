package com.leetcode.demo.easy;

public class DiameterOfBinaryTree {

    int ans;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node1));
        new DiameterOfBinaryTree().test();
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int dfs2(TreeNode root, int val) {
        if (root == null) return val;
        int left = dfs2(root.left, val + 1);
        int right = dfs2(root.right, val + 1);
        return Math.max(left, right);
    }

    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node2.left = node3;
        System.out.println(dfs2(node1, 0));
    }

}
