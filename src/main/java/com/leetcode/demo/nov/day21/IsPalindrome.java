package com.leetcode.demo.nov.day21;

import java.util.LinkedList;

public class IsPalindrome {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: head = [1,2,3,3,2,1]
        //输出: true

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(new IsPalindrome().isPalindrome2(node1));
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode midNode = getMid(head);
        ListNode pre = midNode;
        ListNode cur = pre.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode tmpNode = head;
        ListNode node = null;
        while (pre != midNode) {
            ListNode next = pre.next;
            if (tmpNode.val != pre.val) return false;
            pre.next = node;
            node = pre;
            pre = next;
            tmpNode = tmpNode.next;
        }
        printList(head);
        return true;
    }

    public void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode midNode = getMid(head);
        LinkedList<ListNode> stack = new LinkedList<>();
        while (midNode.next != null) {
            stack.push(midNode.next);
            midNode = midNode.next;
        }
        ListNode tmpNode = head;
        while (!stack.isEmpty()) {
            if (tmpNode.val != stack.pop().val) return false;
            tmpNode = tmpNode.next;
        }
        return true;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
