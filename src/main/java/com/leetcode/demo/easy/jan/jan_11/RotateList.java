package com.leetcode.demo.easy.jan.jan_11;

import com.leetcode.demo.easy.ListNode;

public class RotateList {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], k = 2
        //输出：[4,5,1,2,3]

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode res = new RotateList().rotateRight2(node1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode countLenNode = head;
        while (countLenNode != null) {
            len++;
            countLenNode = countLenNode.next;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode newHead = new ListNode(-1);
        ListNode newList = newHead;
        ListNode tmpHead = newHead;
        for (int i = 1; i < k; i++) {
            ListNode node = new ListNode(-1);
            tmpHead.next = node;
            tmpHead = tmpHead.next;
        }

        tmpHead.next = head;
        ListNode preNode = tmpHead;
        int cur = 0;
        while (cur <= len - k) {
            preNode = tmpHead;
            tmpHead = tmpHead.next;
            cur++;
        }
        preNode.next = null;

        while (tmpHead != null) {
            newList.val = tmpHead.val;
            tmpHead = tmpHead.next;
            newList = newList.next;
        }
        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int len = 1;
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            len++;
        }

        System.out.println("list len is: " + len);
        int steps = len - k % len;
        if (steps == len) return head;
        tmpNode.next = head;
        while (steps > 0) {
            tmpNode = tmpNode.next;
            steps--;
        }

        ListNode resNode = tmpNode.next;
        tmpNode.next = null;
        return resNode;
    }
}
