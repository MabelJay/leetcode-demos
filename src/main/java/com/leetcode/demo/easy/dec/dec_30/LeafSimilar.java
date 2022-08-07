package com.leetcode.demo.easy.dec.dec_30;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root1, list1);
        traverse(root2, list2);
        return list1.equals(list2);
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }
}
