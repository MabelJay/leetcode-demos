package com.leetcode.demo.easy.may.may_25;

import com.leetcode.demo.easy.TreeNode;

public class LowestCommonAncestor2 {

    TreeNode ancestor;

    public static void main(String[] args) {
        // 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        //输出: 3
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor = root;
        dfs(root, p, q);
        return ancestor;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);

        if ((lSon && rSon) || (root.val == p.val || root.val == q.val) && (lSon || rSon)) {
            ancestor = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }
}
