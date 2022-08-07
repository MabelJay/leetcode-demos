package com.leetcode.demo.easy.jan.jan_16;

import com.leetcode.demo.easy.ListNode;

public class DeleteDuplicatesInLink {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,3,4,4,5]
        //输出：[1,2,5]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        // 输入：head = [1,1,1,2,3]
        //输出：[2,3]

        ListNode resNode = new DeleteDuplicatesInLink().deleteDuplicates2(node1);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode first = newHead;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                first.next = cur;
                cur = cur.next;
                first = first.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
        }
        first.next = cur;
        return newHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode cur = newHead;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
