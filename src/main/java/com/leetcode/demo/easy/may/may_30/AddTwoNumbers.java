package com.leetcode.demo.easy.may.may_30;

import com.leetcode.demo.easy.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // 输入：l1 = [7,2,4,3], l2 = [5,6,4]
        //输出：[7,8,0,7]

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;

        ListNode resNode = new AddTwoNumbers().addTwoNumbers(node1, node5);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int left = 0;
        ListNode preNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || left > 0) {
            left += stack1.isEmpty() ? 0 : stack1.pop();
            left += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode curNode = new ListNode(left % 10);
            curNode.next = preNode;
            preNode = curNode;
            left = left / 10;
        }
        return preNode;
    }
}
