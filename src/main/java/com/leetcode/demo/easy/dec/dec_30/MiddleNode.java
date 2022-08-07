package com.leetcode.demo.easy.dec.dec_30;

import com.leetcode.demo.easy.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
        // 输入：[1,2,3,4,5]
        //输出：此列表中的结点 3 (序列化形式：[3,4,5])

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new MiddleNode().middleNode2(node1).val);
    }

    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int index = 0;
        while (index < len / 2) {
            index++;
            head = head.next;
        }
        return head;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
