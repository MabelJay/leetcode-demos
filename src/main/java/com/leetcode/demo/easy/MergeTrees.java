package com.leetcode.demo.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MergeTrees {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
//        node1.right = node3;
        node2.left = node3;

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
//        TreeNode node14 = new TreeNode(4);
//        TreeNode node15 = new TreeNode(7);
        node11.right = node12;
        node12.right = node13;
//        node12.right = node14;
//        node13.right = node15;

        TreeNode node = new MergeTrees().mergeTrees3(node1, node11);
        new MergeTrees().traverseTree(node);
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode tmpNode;
        if (root1 == null) {
            tmpNode = new TreeNode(root2.val);
            tmpNode.left = mergeTrees2(null, root2.left);
            tmpNode.right = mergeTrees2(null, root2.right);
        } else if (root2 == null) {
            tmpNode = new TreeNode(root1.val);
            tmpNode.left = mergeTrees2(root1.left, null);
            tmpNode.right = mergeTrees2(root1.right, null);
        } else {
            tmpNode = new TreeNode(root1.val + root2.val);
            tmpNode.left = mergeTrees2(root1.left, root2.left);
            tmpNode.right = mergeTrees2(root1.right, root2.right);
        }
        return tmpNode;
    }

    public void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode tmpNode = new TreeNode(root1.val + root2.val);
        tmpNode.left = mergeTrees(root1.left, root2.left);
        tmpNode.right = mergeTrees(root1.right, root2.right);
        return tmpNode;
    }

    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left;
            TreeNode right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue1.offer(left1);
                    queue2.offer(left2);
                    queue.offer(left);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right2.val + right1.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}
