package com.leetcode.demo.easy.apr.apr_24;

import com.leetcode.demo.easy.TreeNode;

public class IsValidBST {

    public static void main(String[] args) {
        // 输入：root = [5,1,4,null,null,3,6]
        //输出：false
        //解释：根节点的值是 5 ，但是右子节点的值是 4 。

        // 输入：root = [2,1,3]
        //输出：true

        // [5,4,6,null,null,3,7]

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(3);
        node6.left = node7;
        node6.right = node8;

        System.out.println(new IsValidBST().isValidBST(node6));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
