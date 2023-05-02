package com.leetcode.demo.apr.day04.graph;

import java.util.*;

public class GraphTraverse {

    private static class Node {
        char val;
        List<Node> nexts;

        Node(char val) {
            this.val = val;
            this.nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Node node4 = new Node('D');

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node2.nexts.add(node4);
        node2.nexts.add(node1);
        node4.nexts.add(node2);
        node3.nexts.add(node1);

//        new GraphTraverse().BFS(node1);
        new GraphTraverse().DFS(node1);
    }

    public void BFS(Node node) {
        if (node == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();

        queue.offer(node);
        visitedSet.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.println(tmpNode.val);

            for (Node node1 : tmpNode.nexts) {
                if (!visitedSet.contains(node1)) {
                    queue.offer(node1);
                    visitedSet.add(node1);
                }
            }
        }
    }

    public void DFS(Node node) {
        if (node == null) return;

        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();

        stack.push(node);
        visitedSet.add(node);
        System.out.println(node.val);

        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();

            for (Node next : tmpNode.nexts) {
                if (!visitedSet.contains(next)) {
                    stack.push(tmpNode);
                    stack.push(next);
                    visitedSet.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }
}
