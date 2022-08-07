package com.leetcode.demo.easy.dec.dec_23;

import com.leetcode.demo.easy.TreeNode;

public class FindSecondMinimumValue {
    int ans, rootVal;

    public static void main(String[] args) {
        // [1,1,3,1,1,3,4,3,1,1,8]
        // 3
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

        System.out.println(new FindSecondMinimumValue().findSecondMinNum(node1));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return traverse(root, root.val);
    }

    public int traverse(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val > val) return root.val;
        int left = traverse(root.left, val);
        int right = traverse(root.right, val);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(traverse(root.left, val), traverse(root.right, val));
    }

    public int findSecondMinNum(TreeNode root) {
        ans = -1;
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootVal) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
