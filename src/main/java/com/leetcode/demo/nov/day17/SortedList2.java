package com.leetcode.demo.nov.day17;

public class SortedList2 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        ListNode resNode = new SortedList2().sortList(node1);
//        while (resNode != null) {
//            System.out.print(resNode.val + " ");
//            resNode = resNode.next;
//        }

        new SortedList2().sort(node1, null);
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public void sort(ListNode head, ListNode tail) {
        if (head == null) return;
        ListNode midNode = getMid2(head, tail);
        ListNode[] nodeList = partition(head, midNode.val);
        sort(head, nodeList[0]);
        sort(nodeList[1], tail);
        printList(head);
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode getMid2(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode[] partition(ListNode head, int pivot) {
        ListNode sH = null, sT = null;
        ListNode eH = null, eT = null;
        ListNode lH = null, lT = null;

        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val > pivot) {
                if (lH == null) {
                    lH = head;
                    lT = head;
                } else {
                    lT.next = head;
                    lT = head;
                }
            } else {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = lH;
        }
        return eH == null ? null : new ListNode[]{eH, eT};
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode midNode = getMid(head, tail);
        System.out.println("midNode=" + midNode.val);
        ListNode l1 = sortList(head, midNode);
        ListNode l2 = sortList(midNode, tail);
        return mergeList(l1, l2);
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode tmpNode = dummyNode;
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
        return dummyNode.next;
    }

    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
