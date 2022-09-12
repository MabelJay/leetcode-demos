package com.leetcode.demo.sep_12;

public class DeleteDuplicates {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,3,4,4,5]
        //输出：[1,2,5]

        // 输入：head = [1,1,1,2,3]
        //输出：[2,3]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode resNode = new DeleteDuplicates().deleteDuplicates2(node1);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode preNode = newHead;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            int count = 0;
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
                count++;
            }
            if (count > 1) {
                preNode.next = fast;
            } else {
                preNode = preNode.next;
            }
            slow = fast;
        }
        return newHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode curNode = newHead;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int temp = curNode.next.val;
                while (curNode.next != null && curNode.next.val == temp) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return newHead.next;
    }
}
