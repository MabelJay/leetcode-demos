package com.leetcode.demo.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveSameElements {
    public static void main(String[] args) {
        // 输入：head = [1,2,6,3,4,5,6], val = 6
        //输出：[1,2,3,4,5]

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1 = new RemoveSameElements().removeElements3(node1, 7);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode preNode = new ListNode(-1);
        preNode.next = head;

        ListNode tmpNode = preNode;

        while (tmpNode.next != null) {
            if (val == tmpNode.next.val) {
                tmpNode.next = tmpNode.next.next;
            } else {
                tmpNode = tmpNode.next;
            }
        }
        return preNode.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
