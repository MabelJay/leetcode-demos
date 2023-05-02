package com.leetcode.demo.apr.day13;

import java.util.*;

public class GraphTraverse {

    private static class Node {
        char val;
        List<Node> next;

        Node(char val) {
            this.val = val;
            next = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Node node4 = new Node('D');
        Node node5 = new Node('E');

        node1.next.add(node2);
        node1.next.add(node3);
        node1.next.add(node4);

        node2.next.add(node1);
//        node2.next.add(node3);
        node2.next.add(node5);

        node3.next.add(node1);
//        node3.next.add(node4);

        node4.next.add(node1);
//        node4.next.add(node3);

        node5.next.add(node2);

//        BFS(node1);
        DFS(node1);
    }

    public static void BFS(Node node) {
        if (node == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            for (Node node1 : tmpNode.next) {
                if (!visited.contains(node1)) {
                    queue.offer(node1);
                    visited.add(node1);
                }
            }
        }
    }

    public static void DFS(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
        Set<Node> visited = new HashSet<>();
        System.out.println(node.val);
        visited.add(node);

        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();

            for (Node node1 : tmpNode.next) {
                if (!visited.contains(node1)) {
                    stack.push(tmpNode);
                    stack.push(node1);
                    visited.add(node1);
                    System.out.println(node1.val);
                    break;
                }
            }
        }
    }
}
