package com.leetcode.demo.easy.may.may_07;

public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: 1->2->3->4->5->NULL
        //输出: 5->4->3->2->1->NULL

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new ReverseList().reverseList2(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = null;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        return preNode;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode tmpNode = newHead.next;
        ListNode curNode = tmpNode.next;

        tmpNode.next = null;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = tmpNode;
            tmpNode = curNode;
            curNode = next;
        }
        newHead.next = tmpNode;
        return newHead.next;
    }
}
