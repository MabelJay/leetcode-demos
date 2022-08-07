package com.leetcode.demo.easy;

public class FindTilt {

    int ans;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println(new FindTilt().findTilt(node1));
    }

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return ans;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }
}
