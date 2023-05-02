package com.leetcode.demo.interview.graph;

import java.util.*;

public class DijkstraDemo {

    private static class Node {
        int val;
        boolean isVisited;
        List<Edge> edges;

        Node(int val) {
            this.val = val;
            isVisited = false;
            edges = new ArrayList<>();
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void visit() {
            this.isVisited = true;
        }

        public void unVisit() {
            this.isVisited = false;
        }
    }

    private static class Edge implements Comparable<Edge> {
        Node from;
        Node to;
        int weight;

        Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static class Graph {
        Set<Node> nodes;

        Graph() {
            nodes = new HashSet<>();
        }

        public void addEdge(Node node1, Node node2, int weight) {
            nodes.add(node1);
            nodes.add(node2);
            addEdgeHelper(node1, node2, weight);
        }

        public void addEdgeHelper(Node node1, Node node2, int weight) {
            for (Edge edge : node1.edges) {
                if (edge.from == node1 && edge.to == node2) {
                    edge.weight = weight;
                    return;
                }
            }

            node1.edges.add(new Edge(node1, node2, weight));
        }

        private void dijkstraPath(Node start, Node end) {
            Map<Node, Node> map = new HashMap<>();
            map.put(start, null);
            Map<Node, Integer> shortestMap = new HashMap<>();

            for (Node node : nodes) {
                if (node == start) shortestMap.put(node, 0);
                else {
                    shortestMap.put(node, Integer.MAX_VALUE);
                }
            }

            for (Edge edge : start.edges) {
                shortestMap.put(edge.to, edge.weight);
                map.put(edge.to, start);
            }
            start.visit();

            while (true) {
                Node curNode = closestReachVisit(shortestMap);
                if (curNode == null)
                    throw new RuntimeException("There isn't a path between " + start.val + " and " + end.val);
                if (curNode == end) {
                    System.out.println("There is a path between " + start.val + " and" + end.val + " is:");
                    Node child = curNode;
                    StringBuilder sb = new StringBuilder();
                    while (child != null) {
                        sb.insert(0, child.val + " ");
                        child = map.get(child);
                    }
                    System.out.println("path: " + sb);
                    System.out.println("The total cost is: " + shortestMap.get(end));
                    return;
                }
                curNode.visit();
                for (Edge edge : curNode.edges) {
                    if (edge.to.isVisited) continue;
                    if (shortestMap.get(curNode) + edge.weight < shortestMap.get(edge.to)) {
                        shortestMap.put(edge.to, shortestMap.get(curNode) + edge.weight);
                        map.put(edge.to, curNode);
                    }
                }
            }
        }

        private Node closestReachVisit(Map<Node, Integer> shortestMap) {
            int shortestDistance = Integer.MAX_VALUE;
            Node curNode = null;
            for (Node node : nodes) {
                if (node.isVisited) continue;
                int curDistance = shortestMap.get(node);
                if (curDistance == Integer.MAX_VALUE) continue;
                if (curDistance < shortestDistance) {
                    shortestDistance = curDistance;
                    curNode = node;
                }
            }
            return curNode;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        graph.addEdge(zero, one, 1);
        graph.addEdge(zero, four, 2);
        graph.addEdge(one, two, 1);
        graph.addEdge(two, three, 1);
        graph.addEdge(four, five, 1);
        graph.addEdge(four, three, 1);
        graph.addEdge(three, five, 1);

        graph.dijkstraPath(zero, five);
    }
}
