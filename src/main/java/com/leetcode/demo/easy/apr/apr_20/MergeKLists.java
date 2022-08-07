package com.leetcode.demo.easy.apr.apr_20;

import com.leetcode.demo.easy.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {

    public static void main(String[] args) {
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        //输出：[1,1,2,3,4,4,5,6]

        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = mergeKLists.generateList(1, 2, 3);
        listNodes[1] = mergeKLists.generateList(1, 3, 4);
        listNodes[2] = mergeKLists.generateList(2, 6);

        ListNode[] listNodes1 = new ListNode[0];

        ListNode resNode = mergeKLists.mergeKLists2(listNodes);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    public ListNode generateList(int... args) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for (int num : args) {
            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;
        while (!minHeap.isEmpty()) {
            tmpNode.next = new ListNode(minHeap.poll());
            tmpNode = tmpNode.next;
        }
        return newHead.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] listNodes, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            return mergeTwoLists(mergeList(listNodes, left, mid),  mergeList(listNodes, mid + 1, right));
        }
        if (left == right) return listNodes[left];
        return null;
    }

    public ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmpNode = newHead;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                tmpNode.next = new ListNode(nodeA.val);
                nodeA = nodeA.next;
            } else {
                tmpNode.next = new ListNode(nodeB.val);
                nodeB = nodeB.next;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode.next = nodeA == null ? nodeB : nodeA;
        return newHead.next;
    }
    // public ListNode merge(ListNode[] node, int left, int right) {
    //        if (left == right) return node[left];
    //        if (left < right) {
    //            int mid = left + (right - left) / 2;
    //            return mergeTwoLists(merge(node, left, mid), merge(node, mid + 1, right));
    //        }
    //        return null;
    //    }
    //
    //    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
    //        if (node1 == null || node2 == null) {
    //            return node1 == null ? node2 : node1;
    //        }
    //
    //        ListNode newHead = new ListNode(-1);
    //        ListNode tmp = newHead;
    //        while (node1 != null && node2 != null) {
    //            if (node1.val < node2.val) {
    //                tmp.next = new ListNode(node1.val);
    //                node1 = node1.next;
    //            } else {
    //                tmp.next = new ListNode(node2.val);
    //                node2 = node2.next;
    //            }
    //            tmp = tmp.next;
    //        }
    //        if (node1 != null) tmp.next = node1;
    //        else tmp.next = node2;
    //        return newHead.next;
    //    }
}
