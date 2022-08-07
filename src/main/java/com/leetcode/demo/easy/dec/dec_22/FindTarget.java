package com.leetcode.demo.easy.dec.dec_22;

import com.leetcode.demo.easy.TreeNode;

import java.util.*;

/*
给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class FindTarget {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.right = node6;

        System.out.println(new FindTarget().findTarget3(node4, 9));
    }

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        traverseTree(root, list);
        int len = list.size();
        int i = 0, j = len - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) == k) return true;
            else if (list.get(i) + list.get(j) > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public void traverseTree(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverseTree(root.left, list);
        list.add(root.val);
        traverseTree(root.right, list);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return traverse(root, set, k);
    }

    public boolean traverse(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        else {
            set.add(root.val);
        }
        return traverse(root.left, set, k) || traverse(root.right, set, k);
    }

    public boolean findTarget3(TreeNode root, int k) {
        if (root == null) return false;

        Deque<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            if (set.contains(k - tmpNode.val)) return true;
            else {
                set.add(tmpNode.val);
            }
            if (tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }

            if (tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }
        }
        return false;
    }
}
