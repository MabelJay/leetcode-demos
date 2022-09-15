package com.leetcode.demo.sep_13;

public class DeleteDuplicatesInList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        ListNode resNode = new DeleteDuplicatesInList().deleteDuplicates(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = head;
        ListNode nextNode = head;

        while (nextNode != null) {
            while (nextNode != null && nextNode.val == preNode.val) {
                nextNode = nextNode.next;
            }
            preNode.next = nextNode;
            preNode = nextNode;
        }
        return head;
    }
}
