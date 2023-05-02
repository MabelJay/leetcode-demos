package com.leetcode.demo.interview.graph;

import java.util.*;

public class GraphTraverse {

    private static class Node {
        char val;
        List<Node> nexts;

        Node(char val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Node node4 = new Node('D');

        node1.nexts.add(node2);
        node1.nexts.add(node3);

        node2.nexts.add(node1);
        node3.nexts.add(node1);
        node2.nexts.add(node4);
        node4.nexts.add(node2);

//        BFS(node1);
        DFS(node1);
    }

    public static void BFS(Node node) {
        if (node == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);

        Set<Node> visited = new HashSet<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
    }

    private static void DFS(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        System.out.println(node.val);

        while (!stack.isEmpty()) {
            Node tmpNode = stack.poll();
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
