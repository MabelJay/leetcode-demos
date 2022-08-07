package com.leetcode.demo.easy.jan.jan_26;

import com.leetcode.demo.easy.ListNode;

public class DetectCycle {

    public static void main(String[] args) {
        // 输入：head = [3,2,0,-4], pos = 1
        //输出：返回索引为 1 的链表节点

        // [-1,-7,7,-4,19,6,-9,-5,-2,-5]
        //6


        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(-4);
        ListNode node5 = new ListNode(19);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(-9);
        ListNode node8 = new ListNode(-5);
        ListNode node9 = new ListNode(-2);
        ListNode node10 = new ListNode(-5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node7;

        System.out.println(new DetectCycle().detectCycle(node1).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode tmpNode = head;
                while (tmpNode != slow) {
                    tmpNode = tmpNode.next;
                    slow = slow.next;
                }
                return tmpNode;
            }
        }
        return null;
    }
}
