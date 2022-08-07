package com.leetcode.demo.easy.jan.jan_16;

import com.leetcode.demo.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {

    public static void main(String[] args) {

        // 输入：head = [1,4,3,2,5,2], x = 3
        //输出：[1,2,2,4,3,5]

        // [1,4,3,0,2,5,2]
        //3

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        ListNode node10 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node10;
        node10.next = node4;
        node4.next = node5;
        node5.next = node6;


        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node7.next = node8;

        ListNode res = new PartitionList().partition2(node1, 3);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preNode = newHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                preNode.next = cur;
                cur = cur.next;
                preNode = preNode.next;
            } else {
                list.add(cur.val);
                cur = cur.next;
            }
        }

        for (Integer val : list) {
            preNode.next = new ListNode(val);
            preNode = preNode.next;
        }

        return newHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode large = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                largeHead.next = head;
                largeHead = largeHead.next;
            }

            head = head.next;
        }

        largeHead.next = null;
        smallHead.next = large.next;
        return small.next;
    }
}
