package com.leetcode.demo.easy.jan.jan_21;

import com.leetcode.demo.easy.ListNode;
import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBst {

    ListNode globalHead;

    public static void main(String[] args) {
        // 给定的有序链表： [-10, -3, 0, 5, 9],
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        TreeNode resNode = new SortedListToBst().sortedListToBST(node1);
        traverse(resNode);
    }

    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return buildTree(list, 0, list.size() - 1);
    }

    public TreeNode buildTree(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode rootNode = new TreeNode(list.get(mid));

        rootNode.left = buildTree(list, left, mid - 1);
        rootNode.right = buildTree(list, mid + 1, right);
        return rootNode;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
