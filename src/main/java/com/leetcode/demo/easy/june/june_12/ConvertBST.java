package com.leetcode.demo.easy.june.june_12;

import com.leetcode.demo.easy.TreeNode;

public class ConvertBST {

    int preSum;

    public static void main(String[] args) {
        // 输入：root = [0,null,1]
        //输出：[1,null,1]

        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        node1.right = node2;
        ConvertBST convertBST = new ConvertBST();
        convertBST.preorder(convertBST.convertBST(node1));
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode convertBST(TreeNode root) {
        preSum = 0;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        preSum += root.val;
        root.val = preSum;
        dfs(root.left);
    }
}
