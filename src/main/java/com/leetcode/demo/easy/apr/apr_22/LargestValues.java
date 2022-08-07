package com.leetcode.demo.easy.apr.apr_22;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestValues {
    public static void main(String[] args) {
        //输入: root = [1,3,2,5,3,null,9]
        //输出: [1,3,9]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
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
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                max = Math.max(tmpNode.val, max);
                size--;
            }
            list.add(max);
        }
        return list;
    }
}
