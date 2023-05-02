package com.leetcode.demo.interview;

public class ConstructBstByPreorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：preorder = [8,5,1,7,10,12]
        //输出：[8,5,10,1,7,null,12]

//        TreeNode node1 = new TreeNode(8);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(7);
//        TreeNode node5 = new TreeNode(10);
//        TreeNode node6 = new TreeNode(12);
//
//        node1.left = node2;
//        node1.right = node5;
//        node2.left = node3;
//        node2.right = node4;
//        node5.right = node6;
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = new ConstructBstByPreorder().bstFromPreorder(preorder);
        preorder(root);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildBst(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildBst(int[] preOrder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preOrder[left]);
        int targetIndex = left + 1;
        while (targetIndex <= right && preOrder[targetIndex] < root.val) {
            targetIndex++;
        }
        root.left = buildBst(preOrder, left + 1, targetIndex - 1);
        root.right = buildBst(preOrder, targetIndex, right);
        return root;
    }
}
