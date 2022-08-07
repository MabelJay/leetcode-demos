package com.leetcode.demo.easy.mar.mar_19;

import com.leetcode.demo.easy.ListNode;

public class GetIntersectionNode {
    public static void main(String[] args) {
        // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        //输出：Intersected at '8'

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);

        node6.next = node7;
        node7.next = node8;
//        node8.next = node3;


        ListNode resNode = new GetIntersectionNode().getIntersectionNode(node1, node6);
        System.out.println(resNode == null ? "null" : resNode.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
        int diff = len2 - len1;
        while (diff > 0) {
            headB = headB.next;
            diff--;
        }

        while (diff < 0) {
            headA = headA.next;
            diff++;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
