package com.leetcode.demo.easy.apr.apr_02;

import com.leetcode.demo.easy.ListNode;

public class SwapNodes {

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], k = 2
        //输出：[1,4,3,2,5]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new SwapNodes().swapNodes2(node1, 2);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode tmpNode = head;
        ListNode targetNode1 = head;
        while (tmpNode != null) {
            len++;
            if (len == k) {
                targetNode1 = tmpNode;
            }
            tmpNode = tmpNode.next;
        }

        ListNode tmpNode2 = head;
        int count = 0;
        ListNode targetNode2 = head;
        while (tmpNode2 != null) {
            if (count == len - k) {
                targetNode2 = tmpNode2;
            }
            count++;
            tmpNode2 = tmpNode2.next;
        }
        int tmpNodeVal = targetNode1.val;
        targetNode1.val = targetNode2.val;
        targetNode2.val = tmpNodeVal;
        return head;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        ListNode targetNode1 = head;
        ListNode targetNode2 = head;

        for (int i = 1; i < k; i++) {
            targetNode1 = targetNode1.next;
        }

        ListNode curNode = targetNode1;
        while (curNode.next != null) {
            targetNode2 = targetNode2.next;
            curNode = curNode.next;
        }

        int tmpVal = targetNode1.val;
        targetNode1.val = targetNode2.val;
        targetNode2.val = tmpVal;
        return head;
    }
}
