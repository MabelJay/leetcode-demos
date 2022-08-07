package com.leetcode.demo.easy.apr.apr_20;

import com.leetcode.demo.easy.ListNode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]

        //  1 1
        ListNode node1 = new ListNode(1);
        ListNode resNode = new RemoveNthFromEnd().removeNthFromEnd(node1, 1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }

        int count = 0;
        tmpNode = newHead.next;
        ListNode preNode = newHead;
        while (count < len - n) {
            count++;
            preNode = tmpNode;
            tmpNode = tmpNode.next;
        }
        preNode.next = tmpNode.next;
        return newHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode fastNode = newHead;
        ListNode slowNode = newHead;

        int index = 0;
        while (index < n) {
            fastNode = fastNode.next;
            index++;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;
        return newHead.next;
    }
    // ListNode newHead = new ListNode(-1);
    //        newHead.next = head;
    //        ListNode second = newHead;
    //        ListNode first = second;
    //        for (int i = 0; i < n; i++) {
    //            first = first.next;
    //        }
    //
    //        while (first != null && first.next != null) {
    //            first = first.next;
    //            second = second.next;
    //        }
    //
    //        second.next = second.next.next;
    //        return newHead.next;
}
