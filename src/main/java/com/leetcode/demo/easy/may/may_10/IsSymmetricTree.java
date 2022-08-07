package com.leetcode.demo.easy.may.may_10;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IsSymmetricTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [1,2,2,3,4,4,3]
        //输出：true

        // 输入：root = [1,2,2,null,3,null,3]
        //输出：false

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(new IsSymmetricTree().isSymmetric2(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return checkTree(root, root);
    }

    public boolean checkTree(TreeNode node1, TreeNode node2) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node1);
        queue.offer(node2);

        while (!queue.isEmpty()) {
            TreeNode tmpNode1 = queue.poll();
            TreeNode tmpNode2 = queue.poll();
            if (tmpNode1 == null && tmpNode2 == null) continue;
            else if (tmpNode1 == null || tmpNode2 == null) return false;
            if (tmpNode1.val != tmpNode2.val) return false;
            queue.offer(tmpNode1.left);
            queue.offer(tmpNode2.right);

            queue.offer(tmpNode1.right);
            queue.offer(tmpNode2.left);
        }
        return true;
    }
}
