package com.leetcode.demo.apr.day04.graph;

import java.util.*;

public class GraphTraverse2 {

    private static class Node {
        int val;
        List<Node> nexts;

        Node(int val) {
            this.val = val;
            this.nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.nexts.add(node2);
        node1.nexts.add(node3);

        node2.nexts.add(node1);
        node2.nexts.add(node4);

        node3.nexts.add(node1);

//        new GraphTraverse2().BFS(node1);
        new GraphTraverse2().DFS(node1);
    }

    public void BFS(Node node) {
        if (node == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.pop();
            System.out.println(tmpNode.val);

            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }
    }

    public void DFS(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);

        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();

            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    stack.push(tmpNode);
                    stack.push(next);
                    visited.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }
}
