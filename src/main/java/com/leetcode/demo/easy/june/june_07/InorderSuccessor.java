package com.leetcode.demo.easy.june.june_07;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class InorderSuccessor {

    boolean flag = false;
    TreeNode targetNode;

    public static void main(String[] args) {
        // 输入：root = [5,3,6,2,4,null,null,1], p = 6
        //输出：null

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        System.out.println(new InorderSuccessor().inorderSuccessor(node1, node3).val);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        boolean flag = false;

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (flag && root != null) return root;
            if (root != null && root.val == p.val) flag = true;
            root = root.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        targetNode = null;
        dfs(root, p);
        return targetNode;
    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.left, p);
        if (flag) {
            targetNode = root;
            flag = false;
            return;
        }
        if (root.val == p.val) flag = true;
        dfs(root.right, p);
    }
}
