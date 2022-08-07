package com.leetcode.demo.easy.june.june_09;

import com.leetcode.demo.easy.TreeNode;

import java.util.LinkedList;

public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(new FindBottomLeftValue().findBottomLeftValue(node1));
    }

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode tmpNode = queue.poll();
                if (!flag) {
                    res = tmpNode.val;
                    flag = true;
                }

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
        }
        return res;
    }
}
