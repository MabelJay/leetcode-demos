package com.leetcode.demo.easy;

import java.util.LinkedList;

public class TreeDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        TreeDepth treeDepth = new TreeDepth();
        System.out.println("max depth is: " + treeDepth.maxDepth2(node1));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return Math.max(maxLeftDepth, maxRightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
