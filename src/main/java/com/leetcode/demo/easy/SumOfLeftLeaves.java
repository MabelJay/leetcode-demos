package com.leetcode.demo.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(node1));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && isLeafNode(root.left)) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();

            if (!flag && left != null && isLeafNode(left)) {
                sum += left.val;
            }
            TreeNode right;
            if (flag) {
                right = null;
                flag = false;
            } else {
                right = queue.poll();
            }
            if (left != null) {
                queue.offer(left.left);
                queue.offer(left.right);
            }
            if (right != null) {
                queue.offer(right.left);
                queue.offer(right.right);
            }
        }
        return sum;
    }
}
