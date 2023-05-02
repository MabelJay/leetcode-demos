package com.leetcode.demo.mar.day02;

public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
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
        node1.next.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;

        ListNode resNode = new AddTwoNumbers().addTwoNumbers(node1, node4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int left = 0;
        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + left;
            tmpNode.next = new ListNode(sum % 10);
            left = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            tmpNode = tmpNode.next;
        }
        if (left != 0) {
            tmpNode.next = new ListNode(left);
        }
        return newHead.next;
    }
}
