package com.leetcode.demo.easy;

import java.util.Deque;
import java.util.LinkedList;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        InvertTree tree = new InvertTree();
        tree.preOrderTraverse(tree.invertTree2(n1));

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public void preOrderTraverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree2(root.left);
        root.left = invertTree2(root.right);
        root.right = left;
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            TreeNode temp = tempNode.left;
            tempNode.left = tempNode.right;
            tempNode.right = temp;
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
        return root;
    }
}
