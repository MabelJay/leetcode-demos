package com.leetcode.demo.apr.day04.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    List<Node> nodes;
    Set<Edge> edges;

    public Graph(){
        this.nodes = new ArrayList<>();
        this.edges = new HashSet<>();
    }
}
