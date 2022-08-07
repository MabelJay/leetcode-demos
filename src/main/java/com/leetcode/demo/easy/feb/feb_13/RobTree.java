package com.leetcode.demo.easy.feb.feb_13;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobTree {

    Map<TreeNode, Integer> chosenMap = new HashMap<>();
    Map<TreeNode, Integer> nonChosenMap = new HashMap<>();

    public static void main(String[] args) {
        // 输入: root = [3,2,3,null,3,null,1]
        //输出: 7
        //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(new RobTree().rob2(node1));

        // 输入: root = [3,4,5,1,3,null,1]
        //输出: 9
        //解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9

        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(3);
        TreeNode node11 = new TreeNode(1);

        node6.left = node7;
        node6.right = node8;
        node7.left = node9;
        node7.right = node10;
        node8.right = node11;

        System.out.println(new RobTree().rob2(node6));

        // [4,1,null,2,null,3]
        TreeNode node12 = new TreeNode(4);
        TreeNode node13 = new TreeNode(1);
        TreeNode node14 = new TreeNode(2);
        TreeNode node15 = new TreeNode(3);

        node12.left = node13;
        node13.left = node14;
        node14.left = node15;

        System.out.println(new RobTree().rob2(node12));
    }

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(chosenMap.getOrDefault(root, 0), nonChosenMap.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);

        chosenMap.put(root, root.val + nonChosenMap.getOrDefault(root.left, 0) + nonChosenMap.getOrDefault(root.right, 0));
        nonChosenMap.put(root, Math.max(chosenMap.getOrDefault(root.left, 0), nonChosenMap.getOrDefault(root.left, 0)) +
                Math.max(chosenMap.getOrDefault(root.right, 0), nonChosenMap.getOrDefault(root.right, 0)));
    }

    public int rob2(TreeNode root) {
        int[] status = dfs2(root);
        return Math.max(status[0], status[1]);
    }

    public int[] dfs2(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs2(root.left);
        int[] right = dfs2(root.right);

        int selected = root.val + left[1] + right[1];
        int nonSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, nonSelected};
    }
}
