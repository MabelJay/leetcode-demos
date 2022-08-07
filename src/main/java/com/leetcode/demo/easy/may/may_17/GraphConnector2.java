package com.leetcode.demo.easy.may.may_17;

import java.util.HashMap;
import java.util.Map;

public class GraphConnector2 {
    Map<Character, Character> map;

    public GraphConnector2() {
        this.map = new HashMap<>();
    }

    public void connect(char point1, char point2) {
        if (point1 == point2) return;
        map.put(point1, point2);
    }

    public boolean isConnected(char point1, char point2) {
        if (point1 == point2) return true;
        if (map.containsKey(point1)) {
            Character val = map.get(point1);
            while (val != null) {
                if (val == point2) return true;
                val = map.get(val);
            }
        } else if (map.containsKey(point2)) {
            Character val = map.get(point2);
            while (val != null) {
                if (val == point1) return true;
                val = map.get(val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphConnector2 connector2 = new GraphConnector2();
        System.out.println(connector2.isConnected('A', 'A'));
        connector2.connect('A', 'B');
        System.out.println(connector2.isConnected('A', 'B'));
        System.out.println(connector2.isConnected('A', 'C'));
        System.out.println(connector2.isConnected('B', 'A'));
        connector2.connect('B', 'C');
        System.out.println(connector2.isConnected('A', 'C'));
    }
}
