package com.leetcode.demo.easy.may.may_11;

import java.util.ArrayList;
import java.util.List;

public class TreeTraverse {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        List<Integer> list = new ArrayList<>();
        new TreeTraverse().inorder(node1, list);
        list.forEach(System.out::println);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
//        System.out.print(root.val + " ");
        inorder(root.right, list);
    }
}
