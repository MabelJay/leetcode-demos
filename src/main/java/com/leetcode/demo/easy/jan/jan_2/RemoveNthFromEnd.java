package com.leetcode.demo.easy.jan.jan_2;

import com.leetcode.demo.easy.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new RemoveNthFromEnd().removeNthFromEnd3(node1, 2);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode tmpNode = head;
        int len = 0;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        int index = 0;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        tmpNode = newHead;
        while (index < len - n) {
            tmpNode = tmpNode.next;
            index++;
        }
        if (index == (len - n)) {
            tmpNode.next = tmpNode.next.next;
        }
        return newHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = newHead;
        while (tmpNode != null) {
            stack.push(tmpNode);
            tmpNode = tmpNode.next;
        }


        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        stack.peek().next = stack.peek().next.next;
        return newHead.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode second = newHead;
        ListNode first = second;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return newHead.next;
    }
}
