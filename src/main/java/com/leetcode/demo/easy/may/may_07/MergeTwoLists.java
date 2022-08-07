package com.leetcode.demo.easy.may.may_07;

import com.leetcode.demo.easy.ListNode;

public class MergeTwoLists {

    public static void main(String[] args) {
        // 输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode resNode = new MergeTwoLists().mergeTwoLists2(node1, node4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode tmpNode = newHead;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmpNode.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                tmpNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    tmpNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    tmpNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            tmpNode = tmpNode.next;
        }
        return newHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode tmpNode = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmpNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmpNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmpNode = tmpNode.next;
        }

        tmpNode.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
