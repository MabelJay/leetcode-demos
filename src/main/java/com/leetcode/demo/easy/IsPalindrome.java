package com.leetcode.demo.easy;

public class IsPalindrome {

    private ListNode preNode;

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        IsPalindrome palindrome = new IsPalindrome();
        System.out.println(palindrome.isPalindrome2(node1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(ListNode head) {
        preNode = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode curNode) {
        if (curNode != null) {
            if (!recursivelyCheck(curNode.next)) {
                return false;
            }

            if (curNode.val != preNode.val) return false;

            preNode = preNode.next;
        }

        return true;
    }
}
