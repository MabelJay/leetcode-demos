package com.leetcode.demo.easy.june.june_05;

import com.leetcode.demo.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        // 输入: head = [1,2,3,4]
        //输出: [1,4,2,3]

        // 输入: head = [1,2,3,4,5]
        //输出: [1,5,2,4,3]
    }

    public void reorderList2(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            list.add(tmpNode);
            tmpNode = tmpNode.next;
        }

        int index1 = 0, index2 = list.size() - 1;
        while (index1 < index2) {
            list.get(index1).next = list.get(index2);
            index1++;
            if (index1 == index2) break;
            list.get(index2).next = list.get(index1);
            index2--;
        }
        list.get(index1).next = null;
    }

    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node2 = slow.next;
        slow.next = null;
        ListNode node1 = head;
        node2 = reverseList(node2);

        ListNode next1;
        ListNode next2;
        while (node1 != null && node2 != null) {
            next1 = node1.next;
            next2 = node2.next;

            node1.next = node2;
            node1 = next1;

            node2.next = node1;
            node2 = next2;
        }
    }

    public ListNode reverseList(ListNode node) {
        ListNode preNode = null;
        ListNode curNode = node;

        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }
}
