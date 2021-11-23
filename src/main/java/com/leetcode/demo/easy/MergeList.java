package com.leetcode.demo.easy;

public class MergeList {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(4);
//
//        node1.next = node2;
//        node2.next = node3;
//
//        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(3);
//        ListNode node6 = new ListNode(4);
//        node4.next = node5;
//        node5.next = node6;

        MergeList mergeList = new MergeList();
//        System.out.println(mergeList.mergeTwoLists2(node1, node4));
        mergeList.test1();
    }

    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        System.out.println(mergeTwoLists5(node1, node2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newList = new ListNode();
        ListNode newHead = newList;
        ListNode preList = newList;
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        while (l1Temp != null && l2Temp != null) {
            if (l1Temp.val < l2Temp.val) {
                newList.val = l1Temp.val;
                l1Temp = l1Temp.next;
            } else {
                newList.val = l2Temp.val;
                l2Temp = l2Temp.next;
            }
            preList = newList;
            newList.next = new ListNode();
            newList = newList.next;
        }

        while (l1Temp != null) {
            newList.val = l1Temp.val;
            l1Temp = l1Temp.next;
            preList = newList;
            newList.next = new ListNode();
            newList = newList.next;
        }

        while (l2Temp != null) {
            newList.val = l2Temp.val;
            l2Temp = l2Temp.next;
            preList = newList;
            newList.next = new ListNode();
            newList = newList.next;
        }
        preList.next = null;
        return newHead;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, tail = null;
        int min;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                min = l1.val;
                l1 = l1.next;
            } else {
                min = l2.val;
                l2 = l2.next;
            }
            if (head == null) {
                head = tail = new ListNode(min);
            } else {
                tail.next = new ListNode(min);
                tail = tail.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, tail = null;
        int min;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                min = l1.val;
                l1 = l1.next;
            } else {
                min = l2.val;
                l2 = l2.next;
            }
            if (head == null) {
                head = tail = new ListNode(min);
            } else {
                tail.next = new ListNode(min);
                tail = tail.next;
            }
        }
        tail.next = l1 == null ? l2 : l1;
        return head;
    }

    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1), tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoLists5(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists5(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists5(l1, l2.next);
            return l2;
        }
    }
}
