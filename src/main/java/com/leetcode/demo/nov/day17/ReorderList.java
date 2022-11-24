package com.leetcode.demo.nov.day17;

public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入: head = [1,2,3,4]
        //输出: [1,4,2,3]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode midNode = getMid(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        l2 = reverseList(l2);
        midNode.next = null;

        mergeList(l1, l2);
    }

    public void mergeList(ListNode head1, ListNode head2) {
        ListNode l1Next, l2Next;
        while (head2 != null) {
            l1Next = head1.next;
            l2Next = head2.next;
            head1.next = head2;
            head2.next = l1Next;
            head1 = l1Next;
            head2 = l2Next;
        }
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
