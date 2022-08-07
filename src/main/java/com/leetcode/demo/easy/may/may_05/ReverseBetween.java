package com.leetcode.demo.easy.may.may_05;

import com.leetcode.demo.easy.ListNode;

public class ReverseBetween {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new ReverseBetween().reverseBetween(node1, 1, 4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        int index = 0;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preNode = newHead;
        ListNode tmpNode = preNode.next;
        while (index < left - 1) {
            index++;
            tmpNode = tmpNode.next;
            preNode = preNode.next;
        }

        ListNode cur = tmpNode.next;
        ListNode lastNode = preNode.next;
        while (index < right - 1) {
            ListNode next = cur.next;
            cur.next = tmpNode;
            tmpNode = cur;
            cur = next;
            index++;
        }
        preNode.next = tmpNode;
        lastNode.next = cur;
        return newHead.next;
    }
}
