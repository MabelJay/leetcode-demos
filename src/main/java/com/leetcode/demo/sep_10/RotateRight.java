package com.leetcode.demo.sep_10;

public class RotateRight {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], k = 2
        //输出：[4,5,1,2,3]

        // 输入：head = [0,1,2], k = 4
        //输出：[2,0,1]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new RotateRight().rotateRight(node4, 2);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tmpNode = head;
        int len = 0;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        int moveSteps = k % len;
        if (moveSteps == 0) return head;
        ListNode fast = head;
        ListNode slow = head;

        int index = 0;
        while (index < moveSteps) {
            fast = fast.next;
            index++;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // find targeted
        ListNode next = slow.next;
        slow.next = null;
        fast.next = head;

        return next;
    }
}
