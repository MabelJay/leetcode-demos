package com.leetcode.demo.easy.apr.apr_20;

import com.leetcode.demo.easy.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

    public static void main(String[] args) {
        // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        //输出：Intersected at '8'


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!set.add(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode tmpNode1 = headA;
        ListNode tmpNode2 = headB;
        while (tmpNode1 != null) {
            len1++;
            tmpNode1 = tmpNode1.next;
        }

        while (tmpNode2 != null) {
            len2++;
            tmpNode2 = tmpNode2.next;
        }
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }
        while (len2 > len1) {
            headB = headB.next;
            len2--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode tmpNodeA = headA;
        ListNode tmpNodeB = headB;
        while (tmpNodeA != tmpNodeB) {
            tmpNodeA = tmpNodeA == null ? headB : tmpNodeA.next;
            tmpNodeB = tmpNodeB == null ? headA : tmpNodeB.next;
        }
        return tmpNodeA;
    }

    // if (headA == null || headB == null) return null;
    //
    //        ListNode pA = headA, pB = headB;
    //        while (pA != pB) {
    //            pA = pA == null ? headB : pA.next;
    //            pB = pB == null ? headA : pB.next;
    //        }
    //        return pA;
}
