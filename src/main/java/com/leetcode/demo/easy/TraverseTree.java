package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraverseTree {
    public static void main(String[] args) {
        //[2,3,null,1]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);

        node1.right = node2;
//        node2.left = node3;
        System.out.println(new TraverseTree().inorderTraversal2(node1).toString());
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        inorderTraverse(root, list);
        return list;
    }

    // 递归
    public void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

    // 非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
