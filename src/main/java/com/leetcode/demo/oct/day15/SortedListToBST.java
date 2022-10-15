package com.leetcode.demo.oct.day15;

import java.util.List;

public class SortedListToBST {

    ListNode globalNode;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode() {
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: head = [-10,-3,0,5,9]
        //输出: [0,-3,9,-10,null,5]

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SortedListToBST tree = new SortedListToBST();
        tree.preTraverse(tree.sortedListToBST2(node1));
    }

    private void preTraverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        globalNode = head;
        int len = getListLength(head);
        return buildBST(0, len - 1);
    }

    private int getListLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    public TreeNode buildBST(int left, int right) {
        if (left > right) return null;

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildBST(left, mid - 1);
        root.val = globalNode.val;
        globalNode = globalNode.next;
        root.right = buildBST(mid + 1, right);
        return root;
    }

    private TreeNode buildBST(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode midNode = getMid(left, right);

        TreeNode root = new TreeNode(getMid(left, right).val);
        root.left = buildBST(left, midNode);
        root.right = buildBST(midNode.next, right);
        return root;
    }

    public ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;

        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
