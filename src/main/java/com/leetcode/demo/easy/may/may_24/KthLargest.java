package com.leetcode.demo.easy.may.may_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class KthLargest {

    int res;
    int num;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(new KthLargest().kthLargest2(node4, 1));
    }

    public int kthLargest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.left;
        }
        return -1;
    }

    public int kthLargest2(TreeNode root, int k) {
        res = -1;
        num = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (num == 1 && res == -1) {
            res = root.val;
            return;
        }
        num--;
        dfs(root.left);
    }
}
