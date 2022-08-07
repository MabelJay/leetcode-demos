package com.leetcode.demo.easy.apr.apr_20;

import com.leetcode.demo.easy.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle2 {

    public static void main(String[] args) {
        // 输入：head = [3,2,0,-4], pos = 1
        //输出：返回索引为 1 的链表节点
        //解释：链表中有一个环，其尾部连接到第二个节点。

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println("resNode=" + new DetectCycle2().detectCycle2(node1).val);
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            if (!set.add(tmpNode)) return tmpNode;
            tmpNode = tmpNode.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // get the meet ndoe
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        ListNode newTmpNode = head;
        while (newTmpNode != slow) {
            newTmpNode = newTmpNode.next;
            slow = slow.next;
        }
        return newTmpNode;
    }

    // if (head == null || head.next == null) return null;
    //
    //        ListNode slow = head, fast = head;
    //        while (fast != null) {
    //            slow = slow.next;
    //            if (fast.next != null) {
    //                fast = fast.next.next;
    //            } else {
    //                return null;
    //            }
    //            if (fast == slow) {
    //                ListNode tmpNode = head;
    //                while (tmpNode != slow) {
    //                    tmpNode = tmpNode.next;
    //                    slow = slow.next;
    //                }
    //                return tmpNode;
    //            }
    //        }
    //        return null;
}
