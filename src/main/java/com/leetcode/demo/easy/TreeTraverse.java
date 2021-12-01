package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new TreeTraverse().preorderTraversal2(node1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraverse(root, list);
        return list;
    }

    public void preOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrderTraverse(root.left, list);
        preOrderTraverse(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode.val);
            if (tmpNode.right != null) stack.push(tmpNode.right);
            if (tmpNode.left != null) stack.push(tmpNode.left);
        }
        return list;
    }
}
