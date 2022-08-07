package com.leetcode.demo.easy.may.may_25;

import com.leetcode.demo.easy.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //输出: 6

        // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        //输出: 2
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else break;
        }
        return ancestor;
    }
}
