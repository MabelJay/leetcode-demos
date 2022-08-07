package com.leetcode.demo.easy.jan.jan_20;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class RecoverBST3 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        new RecoverBST3().recoverTree(node1);
        traverse(node1);
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode preNode = null, xNode = null, yNode = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (preNode != null) {
                if (root.val < preNode.val) {
                    yNode = root;
                    if (xNode == null) {
                        xNode = preNode;
                    } else {
                        break;
                    }
                }
            }
            preNode = root;
            root = root.right;
        }
        swap(yNode, xNode);
    }

    public void swap(TreeNode node1, TreeNode node2) {
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }
}
