package com.leetcode.demo.easy.jan.jan_20;

import com.leetcode.demo.easy.TreeNode;

public class RecoverBst2 {

    TreeNode preNode;
    TreeNode xNode;
    TreeNode yNode;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node2.right = node3;
//        node3.left = node4;
//        node3.left = node4;

        new RecoverBst2().recoverTree(node1);
        traverse(node1);
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        recover(root);
        swap(yNode, xNode);
    }

    public void recover(TreeNode node) {
        if (node == null) return;
        recover(node.left);
        if (preNode != null && node.val < preNode.val) {
            if (xNode == null) {
                xNode = preNode;
            }
            yNode = node;
        }
        preNode = node;
        recover(node.right);
    }

    public void swap(TreeNode node1, TreeNode node2) {
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }
}
