package com.leetcode.demo.easy.jan.jan_25;

import com.leetcode.demo.easy.ListNode;

public class InsertionSortList {

    public static void main(String[] args) {
        // 输入: 4->2->1->3
        //输出: 1->2->3->4

        // -1->5->3->4->0
        // -1->5->3->4->0
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new InsertionSortList().insertionSortList(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = head;
        int count = 0;
        ListNode lastNum;
        while (tmpNode.next != null) {
            count++;
            lastNum = tmpNode;
            tmpNode = tmpNode.next;
            if (tmpNode.val < lastNum.val) {
                int index = 0;
                ListNode pre = newHead;
                ListNode cur = pre.next;
                while (index < count) {
                    if (cur.val > tmpNode.val) {
                        lastNum.next = tmpNode.next;
                        tmpNode.next = cur;
                        pre.next = tmpNode;
                        tmpNode = lastNum;
                        break;
                    }
                    pre = cur;
                    cur = cur.next;
                    index++;
                }
            }
        }
        return newHead.next;
    }
}
