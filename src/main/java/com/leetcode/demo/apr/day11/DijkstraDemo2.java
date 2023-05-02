package com.leetcode.demo.apr.day11;

import java.util.*;

public class DijkstraDemo2 {

    private static class Edge implements Comparable<Edge> {
        double weight;
        Node from;
        Node to;

        Edge(double val, Node from, Node to) {
            this.weight = val;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight > o.weight ? 1 : -1;
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
        private boolean visited;
        List<Edge> edges;

        Node(int val) {
            this.val = val;
            visited = false;
            edges = new ArrayList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        void setVisited() {
            visited = true;
        }

        void unVisited() {
            visited = false;
        }
    }

    private static class Graph {
        Set<Node> nodes;
        boolean directed;

        Graph(boolean directed) {
            this.directed = directed;
            nodes = new HashSet<>();
        }

        public void addEdge(Node from, Node to, double weight) {
            nodes.add(from);
            nodes.add(to);

            addEdgeHelper(from, to, weight);
            if (!directed && from != to) {
                addEdgeHelper(to, from, weight);
            }
        }

        private void addEdgeHelper(Node node1, Node node2, double weight) {
            for (Edge edge : node1.edges) {
                if (edge.from == node1 && edge.to == node2) {
                    edge.weight = weight;
                    return;
                }
            }
            node1.edges.add(new Edge(weight, node1, node2));
        }

        public void printEdges() {
            for (Node node : nodes) {
                List<Edge> edges = node.edges;
                if (edges.isEmpty()) {
                    System.out.println("Node " + node.val + " has no edges.");
                    continue;
                }
                System.out.println("Node " + node.val + "has edges to: ");
                for (Edge edge : edges) {
                    System.out.print(edge.to.val + "(" + edge.weight + ") ");
                }
                System.out.println();
            }
        }

        public boolean hasEdge(Node from, Node to) {
            List<Edge> edges = from.edges;
            for (Edge edge : edges) {
                if (edge.to == to) {
                    return true;
                }
            }
            return false;
        }

        public void resetAllNodes() {
            for (Node node : nodes) {
                node.unVisited();
            }
        }

        private void dijkstraPath(Node start, Node end) {
            Map<Node, Node> map = new HashMap<>();
            map.put(start, null);
            Map<Node, Double> shortestPathMap = new HashMap<>();
            for (Node node : nodes) {
                if (node == start) {
                    shortestPathMap.put(start, 0.0);
                } else {
                    shortestPathMap.put(node, Double.POSITIVE_INFINITY);
                }
            }

            for (Edge edge : start.edges) {
                shortestPathMap.put(edge.to, edge.weight);
                map.put(edge.to, start);
            }
            start.setVisited();

            while (true) {
                Node currentNode = closestReachableUnvisited(shortestPathMap);
                if (currentNode == null) {
                    System.out.println("There isn't a path between " + start.val + " and " + end.val);
                    return;
                }
                if (currentNode == end) {
                    System.out.println("The path with the smallest weight between " + start.val + " and " +
                            end.val + " is:");
                    Node child = end;
                    StringBuilder path = new StringBuilder();
                    while (child != null) {
                        path.insert(0, child.val + " ");
                        child = map.get(child);
                    }
                    System.out.println("path: " + path);
                    System.out.println("The path costs: " + shortestPathMap.get(end));
                    return;
                }
                currentNode.setVisited();

                for (Edge edge : currentNode.edges) {
                    if (edge.to.isVisited()) continue;

                    if (shortestPathMap.get(currentNode) + edge.weight < shortestPathMap.get(edge.to)) {
                        shortestPathMap.put(edge.to, shortestPathMap.get(currentNode) + edge.weight);
                        map.put(edge.to, currentNode);
                    }
                }
            }
        }

        private Node closestReachableUnvisited(Map<Node, Double> shortestPathMap) {
            double shortestDistance = Double.POSITIVE_INFINITY;
            Node closestReachableNode = null;
            for (Node node : nodes) {
                if (node.isVisited()) continue;
                double currentDistance = shortestPathMap.get(node);
                if (currentDistance == Double.POSITIVE_INFINITY) continue;
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    closestReachableNode = node;
                }
            }
            return closestReachableNode;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(true);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        graph.addEdge(zero, one, 8);
        graph.addEdge(zero, two, 11);
        graph.addEdge(one, three, 3);
        graph.addEdge(one, four, 8);
        graph.addEdge(one, two, 7);
        graph.addEdge(two, four, 9);
        graph.addEdge(three, four, 5);
        graph.addEdge(three, five, 2);
        graph.addEdge(four, six, 6);
        graph.addEdge(five, four, 1);
        graph.addEdge(five, six, 8);

        graph.dijkstraPath(zero, six);
    }
}
