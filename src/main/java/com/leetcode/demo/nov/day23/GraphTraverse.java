package com.leetcode.demo.nov.day23;

import java.util.*;

public class GraphTraverse {

    private static class Node {
        String value;
        List<Node> nexts;

        public Node(String value) {
            this.value = value;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // A B C D E
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node1.nexts.add(node5);

        node2.nexts.add(node3);
        node2.nexts.add(node4);
        node2.nexts.add(node1);
        node2.nexts.add(node5);

        node3.nexts.add(node1);
        node3.nexts.add(node2);
        node3.nexts.add(node4);

        node4.nexts.add(node3);
        node4.nexts.add(node2);
        node4.nexts.add(node5);

        node5.nexts.add(node1);
        node5.nexts.add(node2);
        node5.nexts.add(node4);

        bfs(node1);
        System.out.println();
        dfs(node1);
    }

    public static void bfs(Node node) {
        if (node == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();

        queue.offer(node);
        visitedSet.add(node);
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.value + " ");

            for (Node next : tmpNode.nexts) {
                if (!visitedSet.contains(next)) {
                    queue.offer(next);
                    visitedSet.add(next);
                }
            }
        }
    }

    public static void dfs(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();
        stack.push(node);
        visitedSet.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            for (Node next : tmpNode.nexts) {
                if (!visitedSet.contains(next)) {
                    stack.push(tmpNode);
                    stack.push(next);
                    visitedSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
