package com.leetcode.demo.easy.may.may_31;

import com.leetcode.demo.easy.ListNode;

public class IsPalindrome {

    ListNode preNode;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(2).append(2);
        System.out.println(new IsPalindrome().isPalindrome(sb));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return isPalindrome(sb);
    }

    public boolean isPalindrome(StringBuilder sb) {
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(ListNode head) {
        preNode = head;
        return recursivelyCheck(preNode);
    }

    public boolean recursivelyCheck(ListNode curNode) {
        if (curNode == null) return true;
        if (!recursivelyCheck(curNode.next)) return false;
        if (curNode.val != preNode.val) return false;
        preNode = preNode.next;
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode endOf1Half = getEndOfFirstHalf(head);
        System.out.println(endOf1Half.val);
        ListNode startOf2Half = reverseList(endOf1Half.next);
        ListNode tmpNode1 = head;
        ListNode tmpNode2 = startOf2Half;
        boolean result = true;
        while (result && tmpNode2 != null) {
            if (tmpNode1.val != tmpNode2.val) result = false;
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }

        endOf1Half.next = reverseList(startOf2Half);
        return result;
    }

    public ListNode getEndOfFirstHalf(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode node) {
        ListNode preNode = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        return preNode;
    }
}
