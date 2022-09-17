package com.leetcode.demo.sep_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(node1));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listTmp = new ArrayList<>();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                listTmp.add(tmpNode.val);
                size--;
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            if (flag) {
                list.add(listTmp);
            } else {
                Collections.reverse(listTmp);
                list.add(listTmp);
            }
            flag = !flag;
        }
        return list;
    }
}
