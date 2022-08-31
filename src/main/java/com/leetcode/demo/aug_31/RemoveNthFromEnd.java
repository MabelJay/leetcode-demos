package com.leetcode.demo.aug_31;

public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new RemoveNthFromEnd().removeNthFromEnd(node1, 2);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode2 = newHead;
        ListNode tmpNode1 = newHead;

        int index = 0;
        while (index < n) {
            tmpNode1 = tmpNode1.next;
            index++;
        }

        while (tmpNode1.next != null) {
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        tmpNode2.next = tmpNode2.next.next;
        return newHead.next;
    }
}
