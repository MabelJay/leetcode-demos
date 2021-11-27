package com.leetcode.demo.easy;

public class SameTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);

        TreeNode node3 = new TreeNode(1);
        node3.left = new TreeNode(2);

        System.out.println(new SameTree().isSameTree(node1, node3));
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else if (root1.val != root2.val) return false;
        else {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
    }
}
