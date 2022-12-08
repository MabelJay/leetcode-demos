package com.leetcode.demo.dec.day04;

import java.util.*;

public class GraphTraverse {

    private static class Node {
        String val;
        List<Node> nexts;

        public Node(String val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        nodeA.nexts.add(nodeB);
        nodeA.nexts.add(nodeC);

        nodeB.nexts.add(nodeA);
        nodeB.nexts.add(nodeD);

        nodeC.nexts.add(nodeA);

        nodeD.nexts.add(nodeB);

//        BFS(nodeA);
//        DFS(nodeA);
//        bfs(nodeA);
        dfs(nodeA);
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
            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
    }

    public static void DFS(Node node) {
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

    public static void bfs(Node node) {
        if (node == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
    }

    public static void dfs(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        stack.push(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();

            for (Node next : tmpNode.nexts) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    stack.push(tmpNode);
                    stack.push(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }
}
