package com.leetcode.demo.easy;

public class NearestCommonAncestor {

    public static void main(String[] args) {

        //[3,1,4,null,2]
        //2 3
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new NearestCommonAncestor().lowestCommonAncestor(node1, node1, node4).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) return root;

        if (p.left == q || p.right == q) return p;
        if (q.left == p || q.right == p) return q;

        if (root.left == p && root.right == q) return root;
        if (root.left == q && root.right == p) return root;

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
