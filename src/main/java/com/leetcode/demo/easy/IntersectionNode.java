package com.leetcode.demo.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    public static void main(String[] args) {

        // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        //输出：Intersected at '8'
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node3.next = node4;
        node2.next = node5;
        node5.next = node6;
        node6.next = node7;
        node4.next = node8;
        node8.next = node5;

        System.out.println(new IntersectionNode().getIntersectionNode3(node1, node3));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int len1 = 0, len2 = 0;

        ListNode tmpNode1 = headA;
        ListNode tmpNode2 = headB;
        while (tmpNode1 != null || tmpNode2 != null) {
            if (tmpNode1 != null) {
                len1++;
                tmpNode1 = tmpNode1.next;
            }
            if (tmpNode2 != null) {
                len2++;
                tmpNode2 = tmpNode2.next;
            }
        }
        while (len2 > len1) {
            headB = headB.next;
            len2--;
        }
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }

        int commonLen = Math.min(len1, len2);
        int index = 0;
        while (index < commonLen) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
