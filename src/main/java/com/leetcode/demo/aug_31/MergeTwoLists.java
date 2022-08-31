package com.leetcode.demo.aug_31;

public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：l1 = [1,2,4], l2 = [1,3,4]
        //输出：[1,1,2,3,4,4]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode resNode = new MergeTwoLists().mergeTwoLists(node1, node4);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmpNode1 = list1;
        ListNode tmpNode2 = list2;
        ListNode tmpNode = newHead;

        while (tmpNode1 != null || tmpNode2 != null) {
            if (tmpNode2 == null || tmpNode1 == null) {
                tmpNode.next = tmpNode1 == null ? tmpNode2 : tmpNode1;
                return newHead.next;
            }

            if (tmpNode1.val < tmpNode2.val) {
                tmpNode.next = new ListNode(tmpNode1.val);
                tmpNode1 = tmpNode1.next;
            } else {
                tmpNode.next = new ListNode(tmpNode2.val);
                tmpNode2 = tmpNode2.next;
            }
            tmpNode = tmpNode.next;
        }

        return newHead.next;
    }
}
