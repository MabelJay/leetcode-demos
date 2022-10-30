package com.leetcode.demo.oct.day30;

public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4]
        //输出：[1,4,2,3]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode midNode = getMidNode(head);

        ListNode head1 = head;
        ListNode head2 = midNode.next;
        midNode.next = null;

        head2 = reverseList(head2);
        mergeList(head1, head2);
    }

    public ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    public void mergeList(ListNode head1, ListNode head2) {
        ListNode tmpNode1;
        ListNode tmpNode2;

        while (head1 != null && head2 != null) {
            tmpNode1 = head1.next;
            tmpNode2 = head2.next;

            head1.next = head2;
            head1 = tmpNode1;
            head2.next = head1;
            head2 = tmpNode2;
        }
    }
}
