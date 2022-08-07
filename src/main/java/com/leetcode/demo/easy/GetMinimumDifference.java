package com.leetcode.demo.easy;

import java.util.*;

public class GetMinimumDifference {
    int pre;
    int ans;

    public static void main(String[] args) {
        //输入：root = [4,2,6,1,3]
        //输出：1

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        //[1,null,3,2]
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(2);
        node6.right = node7;
        node7.left = node8;
        System.out.println(new GetMinimumDifference().inOrderTraverse2(node6));
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        return 0;
    }

    public int levelTraverse(TreeNode root) {
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int minVal = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode tmpNode = nodeQueue.poll();
            list.add(tmpNode.val);
            if (tmpNode.left != null) {
                nodeQueue.offer(tmpNode.left);
            }
            if (tmpNode.right != null) {
                nodeQueue.offer(tmpNode.right);
            }
        }
        System.out.println(list);
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i) - list.get(i - 1);
            if (val < minVal) minVal = val;
        }
        return minVal;
    }

    public int levelTraverse2(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        inOrderTraverse(root);
        return ans;
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) return;
        inOrderTraverse(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        inOrderTraverse(root.right);
    }

    public int inOrderTraverse2(TreeNode root) {
        if (root == null) return 0;
        int minDiff = Integer.MAX_VALUE;
        int pre = -1;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != -1) {
                minDiff = Math.min(Math.abs(root.val - pre), minDiff);
            }
            pre = root.val;
            root = root.right;
        }
        return minDiff;
    }
}
