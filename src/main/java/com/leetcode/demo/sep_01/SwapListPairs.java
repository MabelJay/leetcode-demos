package com.leetcode.demo.sep_01;

public class SwapListPairs {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4]
        //输出：[2,1,4,3]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode resNode = new SwapListPairs().swapPairs(node4);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = newHead;
        while (tmpNode.next != null && tmpNode.next.next != null) {
            ListNode nextNode = tmpNode.next.next.next;
            ListNode node1 = tmpNode.next;
            ListNode node2 = node1.next;
            node2.next = null;
            node1.next = null;
            tmpNode.next = node2;
            node2.next = node1;
            node1.next = nextNode;
            tmpNode = node1;
        }
        return newHead.next;
    }
}
