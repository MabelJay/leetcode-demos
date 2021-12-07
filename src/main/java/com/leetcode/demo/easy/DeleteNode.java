package com.leetcode.demo.easy;

public class DeleteNode {

    public static void main(String[] args) {
        //输入：head = [1,2,3,4], node = 3
        //输出：[1,2,4]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // delete node3
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node3);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
