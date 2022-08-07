package com.leetcode.demo.easy.may.may_17;

import java.util.*;

public class GraphConnector3 {
    Map<Character, List<Character>> map;
    Set<String> set;

    public GraphConnector3() {
        this.map = new HashMap<>();
        set = new HashSet<>();
    }

    public void connect(char point1, char point2) {
        if (point1 == point2) return;
        StringBuilder sb = new StringBuilder();
        if (map.containsKey(point1)) {
            map.get(point1).add(point2);
        } else {
            List<Character> list = new ArrayList<>();
            list.add(point2);
            map.put(point1, list);
        }

        if (map.containsKey(point2)) {
            map.get(point2).add(point1);
        } else {
            List<Character> list = new ArrayList<>();
            list.add(point1);
            map.put(point2, list);
        }
        sb.append(point1).append(point2);
        set.add(sb.toString());
        set.add(sb.reverse().toString());
    }

    public boolean isConnected(char point1, char point2) {
        if (point1 == point2) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(point1).append(point2);
        return set.contains(sb.toString());
    }

    public static void main(String[] args) {

        GraphConnector3 connector = new GraphConnector3();
        connector.connect('A', 'B');
        connector.connect('A', 'C');
        System.out.println(connector.isConnected('B', 'A'));
        System.out.println(connector.isConnected('B', 'C'));
        System.out.println(connector.isConnected('C', 'A'));
    }
}
