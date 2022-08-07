package com.leetcode.demo.easy.may.may_30;

public class RemoveNthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]

        // 输入：head = [1,2], n = 1
        //输出：[1]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new RemoveNthFromEnd().removeNthFromEnd2(node1, 2);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode tmpNode1 = newHead;
        ListNode tmpNode2 = newHead;

        int count = n;
        while (count > 0) {
            tmpNode1 = tmpNode1.next;
            count--;
        }

        while (tmpNode1.next != null) {
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }

        tmpNode2.next = tmpNode2.next.next;
        return newHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        int len = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        int count = len - n;
        ListNode tmpNode2 = head;
        ListNode preNode = newHead;
        while (count > 0) {
            tmpNode2 = tmpNode2.next;
            preNode = preNode.next;
            count--;
        }

        preNode.next = preNode.next.next;
        return newHead.next;
    }
}
