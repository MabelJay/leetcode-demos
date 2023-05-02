package com.leetcode.demo.apr.day30;

public class Rob3 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: root = [3,2,3,null,3,null,1]
        //输出: 7

        // 输入: root = [3,4,5,1,3,null,1]
        //输出: 9
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(new Rob3().rob(node1));
    }

    public int rob(TreeNode root) {
        int[] result = rob2(root);
        return Math.max(result[0], result[1]);
    }

    private int[] rob2(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = rob2(root.left);
        int[] right = rob2(root.right);

        int selected = root.val + left[1] + right[1];
        int nonSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, nonSelected};
    }
}
