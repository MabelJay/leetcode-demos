package com.leetcode.demo.nov.day23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor2 {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        dfs(root, parentMap);
        while (p != null) {
            visited.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right, parentMap);
        }
    }
}
