package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        //输入：root = [1,null,3,2,4,null,5,6]
        //输出：3

        // [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        // [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);

        List<Node> children = new ArrayList<>();
        children.add(node2);
        children.add(node3);
        children.add(node4);
        children.add(node5);
        node1.children = children;

        List<Node> children2 = new ArrayList<>();
        children2.add(node7);
        children2.add(node6);
        node3.children = children2;

        List<Node> list1 = new ArrayList<>();
        list1.add(node8);
        node4.children = list1;

        List<Node> list2 = new ArrayList<>();
        list2.add(node9);
        list2.add(node10);
        node5.children = list2;

        List<Node> list3 = new ArrayList<>();
        list3.add(node11);
        node7.children = list3;

        List<Node> list4 = new ArrayList<>();
        list4.add(node12);
        node8.children = list4;

        List<Node> list5 = new ArrayList<>();
        list5.add(node13);
        node9.children = list5;

        List<Node> list6 = new ArrayList<>();
        list6.add(node14);
        node11.children = list6;

        System.out.println(new MaxDepth().maxDepth3(node1));
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> childList = root.children;
        if (childList == null) return 1;
        int maxVal = 0;
        for (Node node : childList) {
            maxVal = Math.max(maxVal, maxDepth(node));
        }
        return maxVal + 1;
    }

    public int maxDepth2(Node root) {
        if (root == null) return 0;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int lineLen = 1;
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            lineLen--;
            if (lineLen == 0) depth++;
            List<Node> childList = tmpNode.children;
            if (childList != null) {
                for (int i = 0; i < childList.size(); i++) {
                    queue.offer(childList.get(i));
                }
            }
            if (lineLen == 0) lineLen = queue.size();
        }
        return depth;
    }

    public int maxDepth3(Node root) {
        if (root == null) return 0;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node tmpNode = queue.poll();
                List<Node> childList = tmpNode.children;
                if (childList != null) {
                    for (Node node : childList) {
                        queue.offer(node);
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
