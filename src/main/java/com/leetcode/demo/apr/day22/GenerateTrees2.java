package com.leetcode.demo.apr.day22;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees2 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 输入：n = 3
        //输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

        // n=2  output: 2
        List<TreeNode> treeNodeList = new GenerateTrees2().generateTrees(3);
        System.out.println(treeNodeList);
        System.out.println(treeNodeList.size());
//        treeNodeList.forEach(System.out::println);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();

        return getTreeList(1, n);
    }

    private List<TreeNode> getTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSize = getTreeList(start, i - 1);
            List<TreeNode> rightSize = getTreeList(i + 1, end);

            for (TreeNode left : leftSize) {
                for (TreeNode right : rightSize) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
