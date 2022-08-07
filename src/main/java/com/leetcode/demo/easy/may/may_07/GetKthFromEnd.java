package com.leetcode.demo.easy.may.may_07;

import com.leetcode.demo.easy.ListNode;

public class GetKthFromEnd {

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

        ListNode resNode = new GetKthFromEnd().getKthFromEnd2(node1, 2);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        int index = 0;
        ListNode newTmpNode = head;
        while (index < len - k) {
            newTmpNode = newTmpNode.next;
            index++;
        }
        return newTmpNode;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode fastNode = head;
        ListNode slowNode = head;

        int index = 0;
        while (index < k) {
            fastNode = fastNode.next;
            index++;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
