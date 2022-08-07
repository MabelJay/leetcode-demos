package com.leetcode.demo.easy.may.may_11;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public static void main(String[] args) {
        // 给定二叉树: [3,9,20,null,null,15,7],
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(Arrays.toString(new LevelOrder().levelOrder(node1)));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            list.add(tmpNode.val);

            if (tmpNode.left != null) queue.offer(tmpNode.left);
            if (tmpNode.right != null) queue.offer(tmpNode.right);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
