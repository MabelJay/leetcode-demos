package com.leetcode.demo.sep.day02;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n <= 0) return list;
        return getTrees(0, n);
    }

    public List<TreeNode> getTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = getTrees(start, i - 1);
            List<TreeNode> right = getTrees(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
