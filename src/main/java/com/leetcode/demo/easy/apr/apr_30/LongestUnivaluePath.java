package com.leetcode.demo.easy.apr.apr_30;

import com.leetcode.demo.easy.TreeNode;

public class LongestUnivaluePath {

    int maxLen;

    public static void main(String[] args) {
        // 输入：root = [5,4,5,1,1,5]
        //输出：2

        // 输入：root = [1,4,5,4,4,5]
        //输出：2

        // [1,2,2,2,2,2,2,2]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println(new LongestUnivaluePath().longestUnivaluePath(node1));
    }

    public int longestUnivaluePath(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int ansLeft = 0, ansRight = 0;
        if (root.left != null && root.left.val == root.val) {
            ansLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ansRight += right + 1;
        }
        maxLen = Math.max(maxLen, ansLeft + ansRight);
        return Math.max(ansLeft, ansRight);
    }
}
