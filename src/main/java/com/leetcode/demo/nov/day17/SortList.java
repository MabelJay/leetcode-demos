package com.leetcode.demo.nov.day17;

public class SortList {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：head = [4,2,1,3]
        //输出：[1,2,3,4]
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printList(new SortList().sortList(node1));
    }

    public static void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode midNode = getMid(head, tail);
        ListNode l1 = sortList(head, midNode);
        ListNode l2 = sortList(midNode, tail);
        return mergeList(l1, l2);
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tmpNode = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tmpNode.next = head1;
                head1 = head1.next;
            } else {
                tmpNode.next = head2;
                head2 = head2.next;
            }
            tmpNode = tmpNode.next;
        }

        tmpNode.next = head1 == null ? head2 : head1;
        return dummyHead.next;
    }

    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast == tail) break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
