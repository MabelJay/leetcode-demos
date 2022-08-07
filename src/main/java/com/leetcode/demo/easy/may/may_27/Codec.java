package com.leetcode.demo.easy.may.may_27;

import com.leetcode.demo.easy.TreeNode;

import java.util.Arrays;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append("#");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split("#");
        int[] arr2 = new int[arr.length];
        int index = 0;
        for (String each : arr) {
            arr2[index++] = Integer.parseInt(each);
        }

        return buildBST(arr2, 0, arr.length - 1);
    }

    public TreeNode buildBST(int[] arr, int index, int rightPos) {
        if (index == arr.length) return null;

        if (index > rightPos) return null;
        TreeNode root = new TreeNode(arr[index]);
        int targetIndex = index + 1;

        while (targetIndex <= rightPos && arr[targetIndex] < arr[index]) targetIndex++;

        root.left = buildBST(arr, index + 1, targetIndex - 1);
        root.right = buildBST(arr, targetIndex, rightPos);
        return root;
    }

    public static void main(String[] args) {
        // 输入：root = [2,1,3]
        //输出：[2,1,3]
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        node1.left = node2;
        node2.right = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        Codec codec = new Codec();
//        String s = codec.serialize(node1);
//        System.out.println("s=" + s);
//        TreeNode root = codec.deserialize(s);
//        codec.preorder(root);

        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        node7.left = node8;

        String s2 = codec.serialize(node7);
        System.out.println("s2=" + s2);
        TreeNode root2 = codec.deserialize(s2);
        codec.preorder(root2);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}