package com.leetcode.demo.easy.dec.dec_30;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    TreeNode tmpNode;

    public static void main(String[] args) {
        // 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        //输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(new IncreasingBST().increasingBST(node2).val);

        // [2,1,4,null,null,3]
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node4.left = node5;
        node4.right = node6;
        node6.left = node7;
        System.out.println(new IncreasingBST().increasingBST(node4).val);
    }

    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode tmpNode = node;
        for (int i = 1; i < list.size(); i++) {
            tmpNode.right = new TreeNode(list.get(i));
            tmpNode = tmpNode.right;
        }
        return node;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode resNode = new TreeNode(-1);
        tmpNode = resNode;
        traverse2(root);
        return resNode.right;
    }

    public void traverse2(TreeNode root) {
        if (root == null) return;
        traverse2(root.left);
        tmpNode.left = null;
        tmpNode.right = root;
        tmpNode = root;
        traverse2(root.right);
    }
}
