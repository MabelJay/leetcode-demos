package com.leetcode.demo.oct.day30;

public class InsertionSortList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: head = [4,2,1,3]
        //输出: [1,2,3,4]

        //输入: head = [-1,5,3,4,0]
        //输出: [-1,0,3,4,5]
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new InsertionSortList().insertionSortList(node1);
        while (resNode!=null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode curNode = head.next;
        head.next = null;
        while (curNode != null) {
            ListNode tmpNode = dump;
            while (tmpNode.next != null && tmpNode.next.val < curNode.val) {
                tmpNode = tmpNode.next;
            }
            ListNode next = curNode.next;
            curNode.next = tmpNode.next;
            tmpNode.next = curNode;
            curNode = next;
        }
        return dump.next;
    }
}
