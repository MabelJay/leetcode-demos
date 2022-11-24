package com.leetcode.demo.nov.day23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Set<TreeNode> nodeSet = new HashSet<>();

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor2(node1, node2, node3).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            nodeSet.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (nodeSet.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right);
        }
    }
}
