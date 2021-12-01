package com.leetcode.demo.easy;

import java.util.*;

public class HasCycle {
    public static void main(String[] args) {
        //head = [3,2,0,-4], pos = 1
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(new HasCycle().hasCycle3(node1));
    }

    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) return true;
            list.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
