package com.leetcode.demo.easy.june.june_10;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {

    int count = 0;

    public static void main(String[] args) {
        // 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        node3.right = node6;

        System.out.println(new PathSum().pathSum2(node1, 8));
        new PathSum().test();
    }

    public void test() {
        // [1,-2,-3,1,3,-2,null,-1]
        //-1

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-2);
        TreeNode node7 = new TreeNode(-1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        System.out.println(pathSum2(node1, -1));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        if (targetSum == root.val) {
            count++;
//            return;
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        return dfs(root, prefixMap, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Integer, Integer> prefixMap, int curVal, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        curVal += root.val;
        res = prefixMap.getOrDefault(curVal - targetSum, 0);
        prefixMap.put(curVal, prefixMap.getOrDefault(curVal, 0) + 1);
        res += dfs(root.left, prefixMap, curVal, targetSum);
        res += dfs(root.right, prefixMap, curVal, targetSum);
        prefixMap.put(curVal, prefixMap.getOrDefault(curVal, 0) - 1);
        return res;
    }
}
