package com.leetcode.demo.apr.day04.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int val;
    int in;
    int out;

    List<Node> nexts;
    List<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
