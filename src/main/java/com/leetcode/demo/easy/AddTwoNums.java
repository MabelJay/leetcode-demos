package com.leetcode.demo.easy;

public class AddTwoNums {
    public static void main(String[] args) {
        new AddTwoNums().test1();
        new AddTwoNums().test2();
        new AddTwoNums().test3();

        // l1 = [2,4,3], l2 = [5,6,4]

        new AddTwoNums().test4();

    }

    public void test4() {
        //[9,9,1]
        //[1]
        //[0,0,2]
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);

        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;

        System.out.println(addTwoNums2(node1, node4));
    }

    public void test2() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        System.out.println(addTwoNums2(node1, node4));
    }

    public void test3() {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);

        System.out.println(addTwoNums2(node1, node2));
    }

    public void test1() {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        System.out.println(addTwoNums3(node1, node4));
    }

    public ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode head = newList;
        ListNode pre = newList;

        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        boolean flag = false;
        while (l1Temp != null && l2Temp != null) {
            newList.val = l1Temp.val + l2Temp.val;
            flag = calc(flag, newList);
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
            newList.next = new ListNode();
            pre = newList;
            newList = newList.next;
        }

        while (l1Temp != null) {
            newList.val = l1Temp.val;
            flag = calc(flag, newList);
            l1Temp = l1Temp.next;
            newList.next = new ListNode();
            pre = newList;
            newList = newList.next;
        }

        while (l2Temp != null) {
            newList.val = l2Temp.val;
            flag = calc(flag, newList);
            l2Temp = l2Temp.next;
            newList.next = new ListNode();
            pre = newList;
            newList = newList.next;
        }

        if (flag) {
            newList.val = 1;
            newList.next = null;
        } else {
            pre.next = null;
        }

        return head;
    }

    public boolean calc(boolean flag, ListNode newList) {
        if (flag) {
            newList.val += 1;
            flag = false;
        }
        if (newList.val > 9) {
            newList.val %= 10;
            flag = true;
        }
        return flag;
    }

    public ListNode addTwoNums2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNums3(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int sum, carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
