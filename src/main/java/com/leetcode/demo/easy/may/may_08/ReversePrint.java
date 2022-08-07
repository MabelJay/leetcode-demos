package com.leetcode.demo.easy.may.may_08;

import com.leetcode.demo.easy.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class ReversePrint {

    public static void main(String[] args) {
        // 输入：head = [1,3,2]
        //输出：[2,3,1]

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;

        System.out.println(Arrays.toString(new ReversePrint().reversePrint(node1)));
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
