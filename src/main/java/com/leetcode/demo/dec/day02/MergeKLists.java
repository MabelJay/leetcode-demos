package com.leetcode.demo.dec.day02;

public class MergeKLists {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        //输出：[1,1,2,3,4,4,5,6]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode resNode = new MergeKLists().mergeTwoLists2(node1, node4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode tmpNode = null;
        if (l1.val < l2.val) {
            tmpNode = l1;
            tmpNode.next = mergeTwoLists(l1.next, l2);
        } else {
            tmpNode = l2;
            tmpNode.next = mergeTwoLists(l1, l2.next);
        }
        return tmpNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmpNode.next = l1;
                l1 = l1.next;
            } else {
                tmpNode.next = l2;
                l2 = l2.next;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
