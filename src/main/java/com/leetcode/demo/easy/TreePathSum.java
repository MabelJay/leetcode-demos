package com.leetcode.demo.easy;

public class TreePathSum {
    public static void main(String[] args) {

        //root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        //输出：true

        //

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node3.left = node5;
        node3.right = node6;
        node6.right = node9;

        TreePathSum pathSum = new TreePathSum();
        System.out.println(pathSum.hasPathSum(node1, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
