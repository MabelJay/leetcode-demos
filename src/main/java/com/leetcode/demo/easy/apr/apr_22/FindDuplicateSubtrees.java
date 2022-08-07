package com.leetcode.demo.easy.apr.apr_22;

import com.leetcode.demo.easy.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    Map<String, Integer> count;
    List<TreeNode> ans;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
        // 输入：root = [1,2,3,4,null,2,4,null,null,4]
        //输出：[[2,4],[4]]

        // 输入：root = [2,1,1]
        //输出：[[1]]

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

//        System.out.println(node1.equals(node3));
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(node1));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root) {
        if (root == null) return "#";
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) ans.add(root);
        return serial;
    }
}
