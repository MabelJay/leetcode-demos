package com.leetcode.demo.easy;

import java.util.*;

public class TreeTraverse2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        System.out.println(new TreeTraverse2().tree2str3(node1));
    }

    public String tree2str2(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Set<TreeNode> visitedSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.peek();
            if (visitedSet.contains(tmpNode)) {
                stack.pop();
                sb.append(")");
            } else {
                visitedSet.add(tmpNode);
                sb.append("(" + tmpNode.val);
                if (tmpNode.left == null && tmpNode.right != null) {
                    sb.append("()");
                }
                if (tmpNode.right != null) {
                    stack.push(tmpNode.right);
                }
                if (tmpNode.left != null) {
                    stack.push(tmpNode.left);
                }
            }
        }
        return sb.substring(1, sb.length() - 1);
    }

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb = traverse(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    public StringBuilder traverse(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        sb.append("(" + root.val);
        if (root.left == null && root.right == null) {
            return sb.append(")");
        }
        if (root.left == null) {
            sb.append("()");
        }
        traverse(root.left, sb);
        traverse(root.right, sb);
        sb.append(")");
        return sb;
    }

    public String tree2str3(TreeNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str3(t.left) + ")";
        return t.val + "(" + tree2str3(t.left) + ")(" + tree2str3(t.right) + ")";
    }
}
