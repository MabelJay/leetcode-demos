package com.leetcode.demo.aug_07;

public class AddTwoNumInLink {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 输入：l1 = [2,4,3], l2 = [5,6,4]
        //输出：[7,0,8]
        //解释：342 + 465 = 807.

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        ListNode head = new AddTwoNumInLink().addTwoNumbers(node1, node4);
        printList(head);
    }

    public static void printList(ListNode head) {
        if (head == null) return;

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;

        int left = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + left;
            tmpNode.next = new ListNode(sum % 10);
            tmpNode = tmpNode.next;
            left = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (left != 0) {
            tmpNode.next = new ListNode(left);
        }
        return newHead.next;
    }
}
