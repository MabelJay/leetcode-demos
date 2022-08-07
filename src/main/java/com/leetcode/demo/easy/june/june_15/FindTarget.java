package com.leetcode.demo.easy.june.june_15;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {

    boolean flag = false;

    public static void main(String[] args) {
        // 输入: root = [8,6,10,5,7,9,11], k = 12
        //输出: true

        // 输入: root = [8,6,10,5,7,9,11], k = 22
        //输出: false

        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(new FindTarget().findTarget(node1, 12));
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs2(root, set, k);
    }

    public void dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return;

        if (set.contains(k - root.val)) {
            flag = true;
            return;
        }
        set.add(root.val);
        dfs(root.left, set, k);
        dfs(root.right, set, k);
    }

    public boolean dfs2(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs2(root.left, set, k) || dfs2(root.right, set, k);
    }
}
