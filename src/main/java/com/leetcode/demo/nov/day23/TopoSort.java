package com.leetcode.demo.nov.day23;

import java.util.*;

public class TopoSort {

    private static class Node {
        char val;
        int in;
        int out;

        List<Node> nexts;

        public Node(char val) {
            this.val = val;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private static class Graph {
        Map<Character, Node> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        TopoSort topoSort = new TopoSort();
        Graph graph = topoSort.getGraph();
        System.out.println(topoSort.sortTopo(graph));
    }

    public Graph getGraph() {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Node node4 = new Node('D');

        Graph graph = new Graph();

        node1.nexts.add(node2);
        node1.out++;
        node2.in++;
        node1.nexts.add(node3);
        node1.out++;
        node3.in++;

        node2.nexts.add(node3);
        node2.out++;
        node3.in++;

        node3.nexts.add(node4);
        node3.out++;
        node4.in++;

        graph.nodes.put(node1.val, node1);
        graph.nodes.put(node2.val, node2);
        graph.nodes.put(node3.val, node3);
        graph.nodes.put(node4.val, node4);
        return graph;
    }

    public List<Node> sortTopo(Graph graph) {
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroQueue.offer(node);
            }
        }

        List<Node> resultList = new ArrayList<>();
        while (!zeroQueue.isEmpty()) {
            Node tmpNode = zeroQueue.poll();
            resultList.add(tmpNode);

            for (Node next : tmpNode.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroQueue.offer(next);
                }
            }
        }
        return resultList;
    }
}
