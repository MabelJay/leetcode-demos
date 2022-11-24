package com.leetcode.demo.nov.day23;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#_");
            return;
        }

        sb.append(root.val).append("_");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] arr = data.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        return buildTree(queue);
    }

    public TreeNode buildTree(LinkedList<String> queue) {
        String temp = queue.poll();
        if (temp.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(temp));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static void main(String[] args) {
        // 输入：root = [1,2,3,null,null,4,5]
        //输出：[1,2,3,null,null,4,5]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;
        String s = new Codec().serialize(node1);
        new Codec().preorder(new Codec().deserialize(s));
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}