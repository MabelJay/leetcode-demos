package com.leetcode.demo.dec.day02;

public class GetKthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 给定一个链表: 1->2->3->4->5, 和 k = 2.
        //
        //返回链表 4->5.
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new GetKthFromEnd().getKthFromEnd(node5, 1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode tmpNode1 = head;
        ListNode tmpNode2 = head;

        int index = 0;
        while (index < k - 1) {
            if (tmpNode1.next == null) return null;
            tmpNode1 = tmpNode1.next;
            index++;
        }

        while (tmpNode1.next != null) {
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        return tmpNode2;
    }
}
