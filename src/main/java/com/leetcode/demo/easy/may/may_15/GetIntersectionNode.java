package com.leetcode.demo.easy.may.may_15;

public class GetIntersectionNode {

    private static class ListNode {
        int val;
        ListNode next;

        private ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(4);

        node5.next = node6;
        node6.next = node7;
        node7.next = node3;
//        node7.next = node8;
//        node8.next = node9;

        // 3
        //[3]
        //[2,3]
        //0

        ListNode node10 = new ListNode(3);
        ListNode node11 = new ListNode(2);
//        node11.next = node10;
        System.out.println(new GetIntersectionNode().getIntersectionNode2(node1, node5).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmpNode1 = headA;
        ListNode tmpNode2 = headB;

        while (tmpNode1 != tmpNode2) {

            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
            if (tmpNode1 == null && tmpNode2 == null) return null;
            if (tmpNode1 == null)
                tmpNode1 = headB;
            if (tmpNode2 == null) tmpNode2 = headA;
        }
        return tmpNode1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode tmpNode1 = headA;
        ListNode tmpNode2 = headB;

        while (tmpNode1 != tmpNode2) {
            tmpNode1 = tmpNode1 == null ? headB : tmpNode1.next;
            tmpNode2 = tmpNode2 == null ? headA : tmpNode2.next;
        }
        return tmpNode1;
    }
}
