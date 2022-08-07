package com.leetcode.demo.easy.jan.jan_20;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {

    public static void main(String[] args) {

        // [3,1,4,null,null,2]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
        new RecoverBST().recoverTree(node1);
        traverseTree(node1);
    }

    public static void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int val1 = 0, val2 = 0;
        int left = 0;

        while (left < list.size() - 1) {
            if (list.get(left) > list.get(left + 1)) {
                if (val1 == val2) {
                    val1 = list.get(left);
                    val2 = list.get(left + 1);
                } else {
                    val2 = list.get(left + 1);
                    break;
                }
            }
            left++;
        }

        recoverTree(root, val1, val2);
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public void recoverTree(TreeNode root, int val1, int val2) {
        if (root == null) return;
        if (root.val == val1) {
            root.val = val2;
        } else if (root.val == val2) {
            root.val = val1;
        }

        recoverTree(root.left, val1, val2);
        recoverTree(root.right, val1, val2);
    }
}
