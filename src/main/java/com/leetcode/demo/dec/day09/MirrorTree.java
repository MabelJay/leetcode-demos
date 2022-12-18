package com.leetcode.demo.dec.day09;

public class MirrorTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode resNode = new MirrorTree().mirrorTree(node1);
        new MirrorTree().preorder(resNode);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        getMirrorTree(root);
        return root;
    }

    public void getMirrorTree(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
        getMirrorTree(node.left);
        getMirrorTree(node.right);
    }
}
