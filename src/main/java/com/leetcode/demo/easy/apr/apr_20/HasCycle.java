package com.leetcode.demo.easy.apr.apr_20;

import com.leetcode.demo.easy.ListNode;

public class HasCycle {

    public static void main(String[] args) {
        // 输入：head = [3,2,0,-4], pos = 1
        //输出：true
        //解释：链表中有一个环，其尾部连接到第二个节点。

        // 输入：head = [1,2], pos = 0
        //输出：true

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(new HasCycle().hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //  if (head == null || head.next == null) return false;
    //        ListNode slow = head;
    //        ListNode fast = head.next;
    //        while (slow != fast) {
    //            if (fast == null || fast.next == null) return false;
    //            slow = slow.next;
    //            fast = fast.next.next;
    //        }
    //        return true;
}
