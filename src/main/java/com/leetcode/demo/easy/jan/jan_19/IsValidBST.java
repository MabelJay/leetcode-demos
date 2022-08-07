package com.leetcode.demo.easy.jan.jan_19;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    int maxLeftValue = Integer.MIN_VALUE;
    int minRightValue = Integer.MAX_VALUE;
    TreeNode preRoot;

    public static void main(String[] args) {
        // 输入：root = [2,1,3]
        //输出：true

        // 输入：root = [5,1,4,null,null,3,6]
        //输出：false

        // [5,4,6,null,null,3,7]
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

        System.out.println(new IsValidBST().isValidBST2(node1));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root) {
        return traverseTree(root, new ArrayList<>());
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public boolean traverseTree(TreeNode root, List<Integer> list) {
        if (root == null) return true;
        boolean flagLeft = traverseTree(root.left, list);
        if (list.size() == 0 || root.val > list.get(list.size() - 1)) {
            list.add(root.val);
        } else return false;
        boolean flagRight = traverseTree(root.right, list);
        return flagLeft && flagRight;
    }
}
