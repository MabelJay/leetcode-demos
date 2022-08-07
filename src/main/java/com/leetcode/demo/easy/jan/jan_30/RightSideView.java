package com.leetcode.demo.easy.jan.jan_30;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    public static void main(String[] args) {
        // 输入: [1,2,3,null,5,null,4]
        //输出: [1,3,4]

        // [1,2,3,4]
        // 1 3 4

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
//        node3.right = node4;

        System.out.println(new RightSideView().rightSideView2(node1));

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                if (size == 1) list.add(tmpNode.val);
                size--;
            }
        }
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) return;
        if (depth == list.size()) {
            list.add(root.val);
        }

        dfs(root.right, list, depth + 1);
        dfs(root.left, list, depth + 1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }
}
