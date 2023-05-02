package com.leetcode.demo.apr.day14;

import java.util.*;

public class DijkstraDemo {

    private static class Edge implements Comparable<Edge> {
        double weight;
        Node from;
        Node to;

        Edge(Node from, Node to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight > o.weight ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    private static class Node {
        int val;
        boolean visited;
        List<Edge> edges;

        Node(int val) {
            this.val = val;
            visited = false;
            edges = new ArrayList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void visit() {
            visited = true;
        }

        public void unVisit() {
            visited = false;
        }
    }

    private static class Graph {
        Set<Node> nodes;

        Graph() {
            nodes = new HashSet<>();
        }

        public void addEdge(Node from, Node to, double weight) {
            nodes.add(from);
            nodes.add(to);
            addEdgeHelper(from, to, weight);
        }

        public void addEdgeHelper(Node node1, Node node2, double weigh) {
            for (Edge edge : node1.edges) {
                if (edge.from == node1 && edge.to == node2) {
                    edge.weight = weigh;
                    return;
                }
            }
            node1.edges.add(new Edge(node1, node2, weigh));
        }

        private void dijkstraPath(Node start, Node end) {
            Map<Node, Node> map = new HashMap<>();
            map.put(start, null);

            Map<Node, Double> shortestMap = new HashMap<>();
            for (Node node : nodes) {
                if (node == start) {
                    shortestMap.put(node, 0.0);
                } else shortestMap.put(node, Double.POSITIVE_INFINITY);
            }

            for (Edge edge : start.edges) {
                shortestMap.put(edge.to, edge.weight);
                map.put(edge.to, start);
            }
            start.visit();

            while (true) {
                Node currentNode = closestReachUnVisit(shortestMap);
                if (currentNode == null)
                    throw new IllegalArgumentException("there is a path between " + start.val + " and " + end.val);
                if (currentNode == end) {
                    System.out.println("The path with the smallest weight between " + start.val + " and " + end.val + " is:");
                    Node child = currentNode;
                    StringBuilder path = new StringBuilder();
                    while (child != null) {
                        path.insert(0, child.val + " ");
                        child = map.get(child);
                    }
                    System.out.println("path: " + path);
                    System.out.println("The total costs: " + shortestMap.get(end));
                    return;
                }
                currentNode.visit();

                for (Edge edge : currentNode.edges) {
                    if (edge.to.isVisited()) continue;

                    if (shortestMap.get(currentNode) + edge.weight < shortestMap.get(edge.to)) {
                        shortestMap.put(edge.to, shortestMap.get(currentNode) + edge.weight);
                        map.put(edge.to, currentNode);
                    }
                }
            }
        }

        private Node closestReachUnVisit(Map<Node, Double> shortestMap) {
            double shortestDistance = Double.POSITIVE_INFINITY;
            Node closestNode = null;
            for (Node tmpNode : nodes) {
                if (tmpNode.visited) continue;
                double currentDistance = shortestMap.get(tmpNode);
                if (currentDistance == Double.POSITIVE_INFINITY) continue;
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    closestNode = tmpNode;
                }
            }
            return closestNode;
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
