package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafNodeTreePath {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new LeafNodeTreePath().binaryTreePaths2(node1));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;

        treeTraverse(root, list, "");
        return list;
    }

    public void treeTraverse2(TreeNode node, List<String> list, String s) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            s += node.val;
            list.add(s);
        } else {
            s += node.val + "->";
        }

        treeTraverse(node.left, list, s);
        treeTraverse(node.right, list, s);
    }

    public void treeTraverse(TreeNode node, List<String> list, String s) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder(s);
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        } else {
            sb.append("->");
            treeTraverse(node.left, list, sb.toString());
            treeTraverse(node.right, list, sb.toString());
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;


        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode tmpNode = nodeQueue.poll();
            String path = pathQueue.poll();

            if (tmpNode.left == null && tmpNode.right == null) {
                list.add(path);
            } else {
                if (tmpNode.left != null) {
                    nodeQueue.offer(tmpNode.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(tmpNode.left.val).toString());
                }

                if (tmpNode.right != null) {
                    nodeQueue.offer(tmpNode.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(tmpNode.right.val).toString());
                }
            }
        }
        return list;
    }
}
