package com.leetcode.demo.sep_17;

public class IsSymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(new IsSymmetricTree().isSymmetric(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        return checkTree(root, root);
    }

    public boolean checkTree(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2 == null;
        if (node2 == null) return false;

        if (node1.val != node2.val) return false;
        return checkTree(node1.left, node2.right) && checkTree(node1.right, node2.left);
    }
}
