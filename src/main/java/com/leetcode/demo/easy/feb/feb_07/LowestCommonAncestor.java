package com.leetcode.demo.easy.feb.feb_07;

import com.leetcode.demo.easy.TreeNode;

public class LowestCommonAncestor {

    TreeNode ansNode;

    public static void main(String[] args) {
        // 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        //输出：3
        //解释：节点 5 和节点 1 的最近公共祖先是节点 3
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);

        node1.left = node2;
        node1.right = node4;
        node2.right = node3;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(node1, node2, node3));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ansNode = null;
        dfs(root, p, q);
        return ansNode;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ansNode = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
