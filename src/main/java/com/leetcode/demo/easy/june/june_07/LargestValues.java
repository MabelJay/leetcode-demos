package com.leetcode.demo.easy.june.june_07;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestValues {

    public static void main(String[] args) {
        // 输入: root = [1,3,2,5,3,null,9]
        //输出: [1,3,9]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println(new LargestValues().largestValues(node1));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                max = Math.max(max, tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                size--;
            }
            list.add(max);
        }
        return list;
    }
}
