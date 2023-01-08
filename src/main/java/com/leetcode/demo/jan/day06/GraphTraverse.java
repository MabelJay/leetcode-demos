package com.leetcode.demo.jan.day06;

import java.util.*;

public class GraphTraverse {
    private static class GraphNode {
        int val;
        List<GraphNode> nexts;

        public GraphNode(int val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);

        List<GraphNode> list1 = node1.nexts;
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);

        List<GraphNode> list2 = node2.nexts;
        list2.add(node5);
        list2.add(node6);

//        bfs(node1);
        dfs(node1);
    }

    public static void bfs(GraphNode node) {
        if (node == null) return;

        LinkedList<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            GraphNode tmpNode = queue.poll();
            System.out.println(tmpNode.val);
            List<GraphNode> nexts = tmpNode.nexts;
            for (GraphNode next : nexts) {
                if (!set.contains(next)) {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
    }

    public static void dfs(GraphNode node) {
        if (node == null) return;

        LinkedList<GraphNode> stack = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);
        System.out.println(node.val);

        while (!stack.isEmpty()) {
            GraphNode tmpNode = stack.pop();
            for (GraphNode next : tmpNode.nexts) {
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
