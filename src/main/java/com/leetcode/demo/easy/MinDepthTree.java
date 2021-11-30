package com.leetcode.demo.easy;

import java.util.LinkedList;

public class MinDepthTree {
    public static void main(String[] args) {

        // [2,null,3,null,4,null,5,null,6]
        // 5
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        MinDepthTree depthTree = new MinDepthTree();
        System.out.println(depthTree.minDepth(node1));
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (isLeafNode(node)) return minDepth + 1;
                size--;
            }
            minDepth++;
        }
        return minDepth;
    }

    public boolean isLeafNode(TreeNode node) {
        return (node.left == null && node.right == null);
    }
}
