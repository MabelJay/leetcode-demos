package com.leetcode.demo.easy.mar.mar_14;

import com.leetcode.demo.easy.ListNode;

import java.util.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
        //输出：2 -> 1 -> 9，即912
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode resNode = new AddTwoNumbers().addTwoNumbers(node1, node4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int left = 0;

        ListNode newNode = new ListNode(-1);
        ListNode tmpNode = newNode;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int tmpSum = left + num1 + num2;
            left = tmpSum / 10;
            tmpNode.next = new ListNode(tmpSum % 10);
            tmpNode = tmpNode.next;
        }
        if (left != 0) {
            tmpNode.next = new ListNode(left);
        }
        return newNode.next;
    }
}
