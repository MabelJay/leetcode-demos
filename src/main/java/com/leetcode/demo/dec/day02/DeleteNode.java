package com.leetcode.demo.dec.day02;

public class DeleteNode {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: head = [4,5,1,9], val = 5
        //输出: [4,1,9]

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode resHead = new DeleteNode().deleteNode(node1, 5);
        while (resHead != null) {
            System.out.println(resHead.val);
            resHead = resHead.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode tmpNode = head;
        ListNode preNode = newHead;
        while (tmpNode != null) {
            if (tmpNode.val == val) {
                preNode.next = tmpNode.next;
                break;
            }
            preNode = preNode.next;
            tmpNode = tmpNode.next;
        }
        return newHead.next;
    }
}
