package com.leetcode.demo.easy.apr.apr_19;

public class MyLinkedListTest {

    static class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        ListNode listNode;
        int count;

        public MyLinkedList() {
            listNode = new ListNode(-1);
            count = 0;
        }

        public int get(int index) {
            if (index >= count) return -1;
            ListNode tmpNode = listNode;
            while (index >= 0) {
                tmpNode = tmpNode.next;
                index--;
            }
            return tmpNode.val;
        }

        public void addAtHead(int val) {
            ListNode tmpNode = listNode.next;
            ListNode newNode = new ListNode(val);
            listNode.next = newNode;
            newNode.next = tmpNode;
            count++;
        }

        public void addAtTail(int val) {
            ListNode tmpNode = listNode;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = new ListNode(val);
            count++;
        }

        public void addAtIndex(int index, int val) {
            if (index > count) return;
            if (index <= 0) addAtHead(val);
            else if (index == count) addAtTail(val);
            else {
                ListNode tmpNode = listNode;
                while (index > 0) {
                    tmpNode = tmpNode.next;
                    index--;
                }
                ListNode tmpNode2 = tmpNode.next;
                tmpNode.next = new ListNode(val);
                tmpNode.next.next = tmpNode2;
                count++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= count) return;
            ListNode tmpNode = listNode;
            while (index > 0) {
                tmpNode = tmpNode.next;
                index--;
            }
            tmpNode.next = tmpNode.next.next;
            count--;
        }
    }

    public static void main(String[] args) {
        // MyLinkedList linkedList = new MyLinkedList();
        //linkedList.addAtHead(1);
        //linkedList.addAtTail(3);
        //linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        //linkedList.get(1);            //返回2
        //linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        //linkedList.get(1);            //返回3

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(3);
//        new MyLinkedListTest().printList(linkedList);
        linkedList.addAtIndex(1, 2);
        new MyLinkedListTest().printList(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        new MyLinkedListTest().printList(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.addAtHead(11);
        new MyLinkedListTest().printList(linkedList);
        linkedList.addAtTail(22);
        new MyLinkedListTest().printList(linkedList);
        linkedList.addAtIndex(0, 5);
        new MyLinkedListTest().printList(linkedList);
        linkedList.deleteAtIndex(5);
        new MyLinkedListTest().printList(linkedList);
    }

    public void printList(MyLinkedList node) {
        MyLinkedList.ListNode node1 = node.listNode;
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
        System.out.println();
    }
}
