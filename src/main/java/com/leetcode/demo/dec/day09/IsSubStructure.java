package com.leetcode.demo.dec.day09;

public class IsSubStructure {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：A = [3,4,5,1,2], B = [4,1]
        //输出：true
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(1);
        node6.left = node7;

        System.out.println(new IsSubStructure().isSubStructure(node1, node6));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = isSameTree(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;

        if (node1.val != node2.val) return false;
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
