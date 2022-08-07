package com.leetcode.demo.easy.feb.feb_20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiTreeLevelOrder {

    static class Node {
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
        // 输入：root = [1,null,3,2,4,null,5,6]
        //输出：[[1],[3,2,4],[5,6]]

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> child1 = new ArrayList<>();
        child1.add(node2);
        child1.add(node3);
        child1.add(node4);

        node1.children = child1;

        List<Node> child2 = new ArrayList<>();
        child2.add(node5);
        child2.add(node6);

        node2.children = child2;

        System.out.println(new MultiTreeLevelOrder().levelOrder(node1));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            while (size > 0) {
                size--;
                Node tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                List<Node> childList = tmpNode.children;
                if (childList != null) {
                    for (Node child : childList) {
                        queue.offer(child);
                    }
                }
            }
            list.add(tmpList);
        }
        return list;
    }
}
