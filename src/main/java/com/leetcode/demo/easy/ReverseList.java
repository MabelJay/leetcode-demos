package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        //输入：head = [1,2,3,4,5]
        //输出：[5,4,3,2,1]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = new ReverseList().reverseList4(node1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.reverse(list);
        ListNode newHead = null;
        ListNode tempHead = newHead;
        for (Integer i : list) {
            if (newHead == null) {
                newHead = tempHead = new ListNode(i);
            } else {
                tempHead.next = new ListNode(i);
                tempHead = tempHead.next;
            }
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode newHead = null;
        ListNode tempHead = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (newHead == null) {
                newHead = tempHead = new ListNode(list.get(i));
            } else {
                tempHead.next = new ListNode(list.get(i));
                tempHead = tempHead.next;
            }
        }
        return newHead;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
