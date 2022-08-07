package com.leetcode.demo.easy.jan.jan_2;

import com.leetcode.demo.easy.ListNode;

public class SwapPairs {

    public static void main(String[] args) {
        //输入：head = [1,2,3,4]
        //输出：[2,1,4,3]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode resNode = new SwapPairs().swapPairs(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = newHead;

        while (tmpNode != null && tmpNode.next != null) {
            ListNode firstNode = tmpNode.next;
            ListNode secondNode = firstNode.next;
            if (secondNode == null) break;
            tmpNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            tmpNode = firstNode;
        }
        return newHead.next;
    }
}
