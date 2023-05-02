package com.leetcode.demo.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTraverse {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        //输出：[[3],[9,20],[15,7]]

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

//        levelOrder2(node1);
//        levelOrder(node1);
//        inorderTraverse(node1);
//        inorderTraversal(node1);
        preorderTraversal(node1);
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            tmpList = new ArrayList<>();
            while (size > 0) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                size--;
            }
            list.add(tmpList);
        }
        return list;
    }

    public static void levelOrder2(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            if (tmpNode.left != null) queue.offer(tmpNode.left);
            if (tmpNode.right != null) queue.offer(tmpNode.right);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode.val);
            root = tmpNode.right;
        }
//        System.out.println(list);
        return list;
    }

    public static void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode tmpNode = stack1.pop();
            stack2.push(tmpNode);
            if (tmpNode.left != null) stack1.push(tmpNode.left);
            if (tmpNode.right != null) stack1.push(tmpNode.right);
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }

    public static void postorderTraverse(TreeNode root) {
        if (root == null) return;
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode.val);
            if (tmpNode.right != null) stack.push(tmpNode.right);
            if (tmpNode.left != null) stack.push(tmpNode.left);
        }
//        System.out.println(list);
        return list;
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
