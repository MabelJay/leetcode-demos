package com.leetcode.demo.easy.apr.apr_29;

import com.leetcode.demo.easy.ListNode;

public class SwapPairs {
    public static void main(String[] args) {
        // 输入：head = [1,2,3,4]
        //输出：[2,1,4,3]

        // 输入：head = []
        //输出：[]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode resNode = new SwapPairs().swapPairs2(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = newHead.next;
        ListNode preNode = newHead;
        while (tmpNode != null) {
            ListNode node1 = tmpNode;
            ListNode node2 = tmpNode.next;
            if (node2 == null) break;
            node1.next = node2.next;
            node2.next = node1;
            preNode.next = node2;
            preNode = tmpNode;
            tmpNode = tmpNode.next;
        }
        return newHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = newHead;

        while (tmpNode.next != null) {
            ListNode node1 = tmpNode.next;
            ListNode node2 = node1.next;
            if (node2 == null) break;
            tmpNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmpNode = node1;
        }
        return newHead.next;
    }
    // if (head == null || head.next == null) return head;
    //        ListNode newHead = new ListNode(-1);
    //        newHead.next = head;
    //        ListNode tmpNode = newHead;
    //
    //        while (tmpNode != null && tmpNode.next != null) {
    //            ListNode firstNode = tmpNode.next;
    //            ListNode secondNode = firstNode.next;
    //            if (secondNode == null) break;
    //            tmpNode.next = secondNode;
    //            firstNode.next = secondNode.next;
    //            secondNode.next = firstNode;
    //            tmpNode = firstNode;
    //        }
    //        return newHead.next;
}
