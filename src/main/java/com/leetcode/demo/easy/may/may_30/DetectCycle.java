package com.leetcode.demo.easy.may.may_30;

import com.leetcode.demo.easy.ListNode;

public class DetectCycle {

    public static void main(String[] args) {
        // 输入：head = [3,2,0,-4], pos = 1
        //输出：返回索引为 1 的链表节点

        // 输入：head = [1,2], pos = 0

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;

        ListNode resNode = new DetectCycle().detectCycle(node1);
        System.out.println(resNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
