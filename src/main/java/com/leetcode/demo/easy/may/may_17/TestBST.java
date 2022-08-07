package com.leetcode.demo.easy.may.may_17;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TestBST {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(13);

        node1.left = node2;
        node1.right = node4;
        node2.right = node3;
        node4.left = node5;

        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(15);
        TreeNode node9 = new TreeNode(3);
        TreeNode node10 = new TreeNode(12);
        TreeNode node11 = new TreeNode(19);

        node6.left = node7;
        node6.right = node8;
        node7.left = node9;
        node8.left = node10;
        node8.right = node11;

        System.out.println(new TestBST().mergeBst(node1, node6));
    }

    public List<Integer> mergeBst(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1, list1);
        System.out.println("list1=" + list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(root2, list2);
        System.out.println("list2=" + list2);
        if (list1.size() == 0 || list2.size() == 0) return list1.size() == 0 ? list2 : list1;

        int index1 = 0, index2 = 0;
        List<Integer> resList = new ArrayList<>();
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                resList.add(list1.get(index1));
                index1++;
            } else {
                resList.add(list2.get(index2));
                index2++;
            }
        }
        while (index1 < list1.size()) {
            resList.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            resList.add(list2.get(index2++));
        }
        return resList;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
