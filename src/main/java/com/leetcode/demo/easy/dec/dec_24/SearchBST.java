package com.leetcode.demo.easy.dec.dec_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SearchBST {

    public static void main(String[] args) {

        // 4 2 7 1 3
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node = new SearchBST().searchBST(node1, 5);
        new SearchBST().levelTraverse(node);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public void levelTraverse(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            if (tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }
            if (tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }
        }
    }
}
