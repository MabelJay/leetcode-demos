package com.leetcode.demo.easy.apr.apr_26;

import org.xml.sax.ext.Locator2;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    int[] visited;

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        // 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
        //输出：[[2,4],[1,3],[2,4],[1,3]]

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        node1.neighbors = list1;

        List<Node> list2 = new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors = list2;

        List<Node> list3 = new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors = list3;

        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors = list4;

        System.out.println(new CloneGraph().cloneGraph(node1));
    }

    public Node cloneGraph(Node node) {
        visited = new int[101];
        Node newNode = new Node(node.val);
        System.out.println(newNode.val);
        System.out.println(newNode.neighbors.size());
        return dfs(node, newNode);
    }

    public Node dfs(Node node, Node newNode) {
        int index = node.val;
        if (visited[index] != 0) return node;
        visited[index] = 1;
        List<Node> neighbors = new ArrayList<>();
        for (Node v : node.neighbors) {
            Node neiNode = new Node(v.val);
            if (visited[v.val] == 0) {
                neighbors.add(neiNode);
                dfs(v, neiNode);
            } else {
                neighbors.add(neiNode);
            }
        }
        newNode.neighbors = neighbors;
        return newNode;
    }
}
