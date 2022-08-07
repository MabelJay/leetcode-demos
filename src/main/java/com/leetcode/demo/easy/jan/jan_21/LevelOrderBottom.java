package com.leetcode.demo.easy.jan.jan_21;

import com.leetcode.demo.easy.TreeNode;

import java.util.*;

public class LevelOrderBottom {

    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        //输出：[[15,7],[9,20],[3]]

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new LevelOrderBottom().levelOrderBottom3(node1));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                size--;

                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            list.add(tmpList);
        }

        Collections.reverse(list);
        return list;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                stack.push(tmpNode.val);
                size--;
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
            }
            stack.push(Integer.MIN_VALUE);
        }

        while (!stack.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();

            while (!stack.isEmpty() && stack.peek() > Integer.MIN_VALUE) {
                tmpList.add(stack.pop());
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
            if (tmpList.size()>0) {
                list.add(tmpList);
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom3(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                size--;

                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            list.add(0, tmpList);
        }

        return list;
    }
}
