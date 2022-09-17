package com.leetcode.demo.sep_17;

public class ReverseListBetween {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resNode = new ReverseListBetween().reverseBetween(node1, 2, 4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newList = new ListNode(-1);
        newList.next = head;

        ListNode preNode = newList;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        ListNode curNode = preNode.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curNode.next.next;
            curNode.next.next = preNode.next;
            preNode.next = curNode.next;
            curNode.next = next;
        }
        return newList.next;
    }
}
