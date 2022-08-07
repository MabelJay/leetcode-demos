package com.leetcode.demo.easy.jan.jan_23;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenTree {

    List<TreeNode> tmpNodeList;
    TreeNode preNode;

    public static void main(String[] args) {
        // 输入：root = [1,2,5,3,4,null,6]
        //输出：[1,null,2,null,3,null,4,null,5,null,6]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        // [1,null,2,3]
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(3);
        node7.left = node8;
        node7.right = node9;
        new FlattenTree().flatten7(node7);
        System.out.println(node7);
    }

    public void flatten(TreeNode root) {
        tmpNodeList = new ArrayList<>();
        preNode = root;
        dfs2(root);
        System.out.println(root);
    }

    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traverTree(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    public void flatten3(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode);
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }

        System.out.println(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
        System.out.println(root);
    }

    public void traverTree(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        traverTree(root.left, list);
        traverTree(root.right, list);
    }

    public TreeNode dfs2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        tmpNodeList.add(root.right);

        preNode = root;
        root.right = dfs2(root.left);
        root.left = null;
        if (preNode.right != null) {
            preNode = preNode.right;
        }
        preNode.right = dfs2(tmpNodeList.get(tmpNodeList.size() - 1));
        tmpNodeList.remove(tmpNodeList.size() - 1);
        return root;
    }

    public void flatten4(TreeNode root) {
        if (root == null) return;

        TreeNode preNode = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            if (preNode != null) {
                preNode.right = tmpNode;
                preNode.left = null;
            }

            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }

            preNode = tmpNode;
        }
    }

    public void flatten5(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public void flatten6(TreeNode root) {
        if (root == null) return;
        flatten6(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten6(right);
        root.right = right;
    }


    public void flatten7(TreeNode root) {
        if (root == null) return;
        flatten7(root.left);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten7(rightNode);
        root.right = rightNode;
    }
}