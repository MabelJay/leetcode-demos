package com.leetcode.demo.oct.day28;

public class SumNumbers {

    int sum;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        //输出：25

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new SumNumbers().sumNumbers(node1));

        // 输入：root = [4,9,0,5,1]
        //输出：1026
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(1);
        node4.left = node5;
        node4.right = node6;
        node5.left = node7;
        node5.right = node8;
        System.out.println(new SumNumbers().sumNumbers(node4));

        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(0);
        node9.left = node10;
        System.out.println(new SumNumbers().sumNumbers(node9));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int preVal) {
        if (root.left == null && root.right == null) {
            sum += preVal * 10 + root.val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, preVal * 10 + root.val);
        }
        if (root.right!=null) {
            dfs(root.right, preVal * 10 + root.val);
        }
    }
}
