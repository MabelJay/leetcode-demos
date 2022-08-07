package com.leetcode.demo.easy.may.may_09;

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

        // 输入: head = [4,5,1,9], val = 1
        //输出: [4,5,9]

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode resNode = new DeleteNode().deleteNode(node1, 5);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode pre = newHead;
        while (head.val != val) {
            pre = pre.next;
            head = head.next;
        }

        pre.next = head.next;
        return newHead.next;
    }
}
