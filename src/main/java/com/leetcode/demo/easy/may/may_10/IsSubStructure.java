package com.leetcode.demo.easy.may.may_10;

import com.leetcode.demo.easy.TreeNode;

public class IsSubStructure {

    public static void main(String[] args) {
        // 输入：A = [1,2,3], B = [3,1]
        //输出：false

        // 输入：A = [3,4,5,1,2], B = [4,1]
        //输出：true

        // [1,0,1,-4,-3]
        //[1,-4]

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(-4);
        TreeNode node5 = new TreeNode(-3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(-4);
        node6.left = node7;
        System.out.println(new IsSubStructure().isSubStructure(node1, node6));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null || node1.val != node2.val) return false;
        return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }
}
