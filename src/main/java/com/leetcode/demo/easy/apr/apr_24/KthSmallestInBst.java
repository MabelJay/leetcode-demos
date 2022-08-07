package com.leetcode.demo.easy.apr.apr_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class KthSmallestInBst {

    public static void main(String[] args) {
        // 输入：root = [3,1,4,null,2], k = 1
        //输出：1
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new KthSmallestInBst().kthSmallest(node1, 2));
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
