package com.leetcode.demo.nov.day21;

import java.util.LinkedList;

public class TreeTraverse {
    private static class TreeNode {
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
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.preorder(node1);
        System.out.println();
        treeTraverse.inorder(node1);
        System.out.println();
        treeTraverse.postorder(node1);
        System.out.println();
        treeTraverse.preorder1(node1);
        System.out.println();
        treeTraverse.inorder1(node1);
        System.out.println();
        treeTraverse.postorder2(node1);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public void preorder1(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            System.out.print(tmpNode.val + " ");
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
    }

    public void inorder1(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmpNode = stack.pop();
            System.out.print(tmpNode.val + " ");
            root = tmpNode.right;
        }
    }

    public void postorder2(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode tmpNode = stack1.pop();
            stack2.push(tmpNode);
            if (tmpNode.left != null) {
                stack1.push(tmpNode.left);
                stack1.push(tmpNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }
}
