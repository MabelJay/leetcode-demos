package com.leetcode.demo.easy.apr.apr_04;

import com.leetcode.demo.easy.TreeNode;

public class SumTreeNumbers {

    public int sum;

    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        //输出：25

        // 输入：root = [4,9,0,5,1]
        //输出：1026

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(new SumTreeNumbers().sumNumbers(node1));
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (isLeafNode(root)) {
            sum += Integer.parseInt(sb.toString());
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
