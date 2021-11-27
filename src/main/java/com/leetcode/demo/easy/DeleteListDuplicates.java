package com.leetcode.demo.easy;

public class DeleteListDuplicates {
    public static void main(String[] args) {
        //输入：head = [1,1,2]
        //输出：[1,2]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(6);

//        node1.next = node2;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        DeleteListDuplicates duplicates = new DeleteListDuplicates();
        System.out.println(duplicates.deleteDuplicates2(node1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tmpHead = head.next;
        ListNode preNode = head;
        while (tmpHead != null) {
            if (preNode.val == tmpHead.val) {
                preNode.next = tmpHead.next;
            } else {
                preNode = tmpHead;
            }
            tmpHead = tmpHead.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}
