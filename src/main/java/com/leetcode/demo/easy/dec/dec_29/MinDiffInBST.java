package com.leetcode.demo.easy.dec.dec_29;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinDiffInBST {

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

        System.out.println(new MinDiffInBST().minDiffInBST(node1));
    }

    public int minDiffInBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(minDiff, list.get(i + 1) - list.get(i));
        }
        return minDiff;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        pre = -1;
        ans = Integer.MAX_VALUE;
        traverse2(root);
        return ans;
    }

    public void traverse2(TreeNode root) {
        if (root == null) return;
        traverse2(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        traverse2(root.right);
    }
}
