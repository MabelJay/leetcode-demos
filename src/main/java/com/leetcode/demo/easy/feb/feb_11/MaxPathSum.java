package com.leetcode.demo.easy.feb.feb_11;

import com.leetcode.demo.easy.TreeNode;

public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        //输出：6

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        // 输入：root = [-10,9,20,null,null,15,7]
        //输出：42
        //解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

        // [0,1,1]
        // 2

        // [1,-2,-3,1,3,-2,null,-1]
        // 3
        TreeNode node4 = new TreeNode(-10);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(20);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(7);

        node4.left = node5;
        node4.right = node6;
        node6.left = node7;
        node6.right = node8;

        TreeNode node9 = new TreeNode(0);
        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        node9.left = node10;
        node9.right = node11;

        // [1,-2,-3,1,3,-2,null,-1]
        // 3
        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(-2);
        TreeNode node14 = new TreeNode(-3);
        TreeNode node15 = new TreeNode(1);
        TreeNode node16 = new TreeNode(3);
        TreeNode node17 = new TreeNode(-2);
        TreeNode node18 = new TreeNode(-1);
        node12.left = node13;
        node12.right = node14;
        node13.left = node15;
        node13.right = node16;
        node14.left = node17;
        node14.right = node18;

        // [1,-2,3]
        // 4

        TreeNode node19 = new TreeNode(1);
        TreeNode node20 = new TreeNode(-2);
        TreeNode node21 = new TreeNode(3);
        node19.left = node20;
        node19.right = node21;

        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        // 48

        TreeNode node22 = new TreeNode(5);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(11);
        TreeNode node25 = new TreeNode(7);
        TreeNode node26 = new TreeNode(2);
        TreeNode node27 = new TreeNode(8);
        TreeNode node28 = new TreeNode(13);
        TreeNode node29 = new TreeNode(4);
        TreeNode node30 = new TreeNode(1);

        node22.left = node23;
        node22.right = node27;
        node23.left = node24;
        node24.left = node25;
        node24.right = node26;
        node27.left = node28;
        node27.right = node29;
        node29.right = node30;
        System.out.println(new MaxPathSum().maxPathSum(node9));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = Math.max(dfs(root.left), 0);
        int maxRight = Math.max(dfs(root.right), 0);

        int curVal = maxLeft + maxRight + root.val;

        maxSum = Math.max(maxSum, curVal);

        return root.val + Math.max(maxLeft, maxRight);
    }
}
