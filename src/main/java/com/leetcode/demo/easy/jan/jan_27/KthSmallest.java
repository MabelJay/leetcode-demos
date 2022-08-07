package com.leetcode.demo.easy.jan.jan_27;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class KthSmallest {

    int count;
    int res;

    public static void main(String[] args) {
        // 输入：root = [3,1,4,null,2], k = 1
        //输出：1

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new KthSmallest().kthSmallest(node1, 1));
    }

    public int kthSmallest2(TreeNode root, int k) {
        count = 1;
        res = -1;
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        if (count == k) {
            res = root.val;
            count++;
            return;
        }
        count++;
        dfs(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 1;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (count == k) return stack.pop().val;
            count++;
            root = root.right;
        }

        return -1;
    }
}
