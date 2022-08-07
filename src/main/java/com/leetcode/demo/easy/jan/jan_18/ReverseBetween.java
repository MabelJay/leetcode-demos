package com.leetcode.demo.easy.jan.jan_18;

import com.leetcode.demo.easy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseBetween {

    ListNode preNode;
    ListNode tmp;
    boolean flag = true;

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]

        // [0,1,4,-2]
        //4 4
        // [0,1,4,-2]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new ReverseBetween().reverseBetween(node1, 1, 5);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = head;
        ListNode preNode = newHead;
        while (count < left) {
            count++;
            preNode = tmpNode;
            tmpNode = tmpNode.next;
        }

        ListNode secondNode = tmpNode.next;
        tmpNode.next = null;
        while (count < right) {
            count++;
            ListNode tmp = secondNode.next;
            secondNode.next = tmpNode;
            tmpNode = secondNode;
            secondNode = tmp;
        }
        preNode.next = tmpNode;
        while (preNode.next != null) {
            preNode = preNode.next;
        }
        preNode.next = secondNode;
        return newHead.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tmpNode = head;
        ListNode preNode = newHead;
        while (count < left) {
            preNode = tmpNode;
            tmpNode = tmpNode.next;
            count++;
        }

        List<Integer> list = new ArrayList<>();
        while (count <= right) {
            list.add(tmpNode.val);
            count++;
            tmpNode = tmpNode.next;
        }
        System.out.println(list);
        Collections.reverse(list);
        for (Integer val : list) {
            preNode.next = new ListNode(val);
            preNode = preNode.next;
        }
        preNode.next = tmpNode;
        return newHead.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        preNode = head;
        ListNode preNode2 = newHead;
        while (count < left) {
            count++;
            preNode2 = preNode;
            preNode = preNode.next;
        }
        int diff = right - left;
        ListNode resNode = resetNode(preNode.next, 0, diff);
        preNode2.next = resNode;
        while (preNode2.next!=null) {
            preNode2 = preNode2.next;
        }
        preNode2.next = tmp;
        return newHead.next;
    }

    public ListNode resetNode(ListNode curNode, int index, int diff) {
        if (index == diff) return preNode;
        tmp = curNode.next;
        curNode.next = preNode;
        if (flag) {
            preNode.next = null;
            flag = false;
        }
        preNode = curNode;
        curNode = tmp;
        return resetNode(curNode, index + 1, diff);
    }
}
