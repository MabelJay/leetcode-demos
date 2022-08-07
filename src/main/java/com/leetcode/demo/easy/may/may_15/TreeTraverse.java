package com.leetcode.demo.easy.may.may_15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        new TreeTraverse().preorder(node1);
        System.out.println();
        new TreeTraverse().preOrder2(node1);
        System.out.println();
        new TreeTraverse().inorder(node1);
        System.out.println();
        new TreeTraverse().inorder2(node1);
        System.out.println();
        new TreeTraverse().postorder(node1);
        System.out.println();
        System.out.println(new TreeTraverse().postOrder2(node1));
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void preOrder2(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            System.out.print(tmpNode.val + " ");
            if (tmpNode.right != null) stack.push(tmpNode.right);
            if (tmpNode.left != null) stack.push(tmpNode.left);
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void inorder2(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
