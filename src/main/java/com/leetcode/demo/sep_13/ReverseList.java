package com.leetcode.demo.sep_13;

public class ReverseList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

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

        ListNode resNode = new ReverseList().reverseList(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preNode = newHead;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        ListNode cur = preNode.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = preNode.next;
            preNode.next = next;
        }
        return newHead.next;
    }
}
