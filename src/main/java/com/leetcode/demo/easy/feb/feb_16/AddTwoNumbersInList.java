package com.leetcode.demo.easy.feb.feb_16;

import com.leetcode.demo.easy.ListNode;
import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbersInList {

    public static void main(String[] args) {
        // 输入：l1 = [7,2,4,3], l2 = [5,6,4]
        //输出：[7,8,0,7]

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(5);

        ListNode node10 = new ListNode(0);
        ListNode node11 = new ListNode(7);
        ListNode node12 = new ListNode(3);

        node11.next = node12;
        ListNode resNode = new AddTwoNumbersInList().addTwoNumbers2(node8, node9);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int left = 0;
        List<Integer> resList = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + left;
            left = sum / 10;
            resList.add(sum % 10);
        }
        if (left != 0) resList.add(left);
        for (int i = resList.size() - 1; i >= 0; i--) {
            tmpNode.next = new ListNode(resList.get(i));
            tmpNode = tmpNode.next;
        }
        return newHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
        ListNode tmpNode = null;
        int left = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = left + (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop());
            left = sum / 10;
            ListNode curNode = new ListNode(sum % 10);
            curNode.next = tmpNode;
            tmpNode = curNode;
        }
        if (left != 0) {
            ListNode curNode = new ListNode(left);
            curNode.next = tmpNode;
            tmpNode = curNode;
        }
        return tmpNode;
    }
}
