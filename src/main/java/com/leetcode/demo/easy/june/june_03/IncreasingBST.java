package com.leetcode.demo.easy.june.june_03;

import com.leetcode.demo.easy.ListNode;
import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    private TreeNode commonParent;

    public static void main(String[] args) {
        // 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        //输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node3.right = node6;
        node6.left = node8;
        node6.right = node9;

        IncreasingBST increasingBST = new IncreasingBST();
        increasingBST.preorder(increasingBST.increasingBST2(node1));
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        commonParent = dummyNode;
        buildBST(root);
        return dummyNode.right;
    }

    public void buildBST(TreeNode root) {
        if (root == null) return;
        buildBST(root.left);

        commonParent.right = root;
        root.left = null;
        commonParent = root;
        buildBST(root.right);
    }

    public TreeNode increasingBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        TreeNode newRoot = new TreeNode(-1);
        TreeNode tmpNode = newRoot;
        for (int val : list) {
            tmpNode.right = new TreeNode(val);
            tmpNode = tmpNode.right;
        }
        return newRoot.right;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
