package com.leetcode.demo.nov.day23;

import java.util.LinkedList;

public class IsValidBST {

    long preNodeVal;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [5,1,4,null,null,3,6]
        //输出：false

        // 输入：root = [2,1,3]
        //输出：true
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);


        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new IsValidBST().isValidBst2(node1));
    }

    public boolean isValidBST(TreeNode root) {
        preNodeVal = Long.MIN_VALUE;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;

        boolean left = dfs(root.left);
        if (root.val <= preNodeVal) {
            return false;
        } else {
            preNodeVal = root.val;
        }
        boolean right = dfs(root.right);
        return left && right;
    }

    public boolean isValidBst2(TreeNode root) {
        if (root == null) return true;

        long minVal = Long.MIN_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmpNode = stack.pop();
            if (tmpNode.val <= minVal) return false;
            minVal = tmpNode.val;
            root = tmpNode.right;
        }
        return true;
    }
}
