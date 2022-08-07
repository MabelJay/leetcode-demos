package com.leetcode.demo.easy.may.may_17;

import com.leetcode.demo.easy.TreeNode;

public class MergeTrees {

    public static void main(String[] args) {
        // 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        //输出：[3,4,5,5,4,null,7]

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);

        node5.left = node6;
        node5.right = node7;
        node6.right = node8;
        node7.right = node9;

        TreeNode resNode = new MergeTrees().merge(node1, node5);
        new MergeTrees().traverse(resNode);
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        TreeNode rightNode = mergeTrees(root1.right, root2.right);

        newRoot.left = leftNode;
        newRoot.right = rightNode;
        return newRoot;
    }
}
