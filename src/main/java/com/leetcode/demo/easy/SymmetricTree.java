package com.leetcode.demo.easy;

import java.util.LinkedList;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node7;
        SymmetricTree tree = new SymmetricTree();
        System.out.println(tree.isSymmetric(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check1(root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean check1(TreeNode p) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (p.left == null && p.right == null) return true;
        if (p.left == null || p.right == null) return false;
        queue.offer(p.left);
        queue.offer(p.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) continue;
            if ((node1 == null || node2 == null) || node1.val != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
