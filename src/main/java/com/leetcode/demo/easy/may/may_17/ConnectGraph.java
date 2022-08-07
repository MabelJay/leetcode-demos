package com.leetcode.demo.easy.may.may_17;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectGraph {

    static class GraphConnector {

        static class GraphPoint {
            char point;

            public GraphPoint(char point) {
                this.point = point;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                GraphPoint that = (GraphPoint) o;
                return point == that.point;
            }

            @Override
            public int hashCode() {
                return Objects.hash(point);
            }
        }

        Map<GraphPoint, GraphPoint> map;

        public GraphConnector() {
            map = new HashMap<>();
        }

        public void connect(GraphPoint point1, GraphPoint point2) {
            if (point1.equals(point2)) return;
            map.put(point1, point2);
        }

        public boolean isConnected(GraphPoint point1, GraphPoint point2) {
            if (point1 == point2) return true;
            if (map.containsKey(point1)) {
                GraphPoint val = map.get(point1);
                if (point2.equals(val)) return true;
                if (point2.equals(map.get(val))) return true;
            } else if (map.containsKey(point2)) {
                GraphPoint val = map.get(point2);
                if (point1.equals(val)) return true;
                if (point1.equals(map.get(val))) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        GraphConnector graphConnector = new GraphConnector();
        GraphConnector.GraphPoint point1 = new GraphConnector.GraphPoint('A');
        GraphConnector.GraphPoint point2 = new GraphConnector.GraphPoint('B');
        GraphConnector.GraphPoint point3 = new GraphConnector.GraphPoint('C');
        GraphConnector.GraphPoint point4 = new GraphConnector.GraphPoint('D');
        GraphConnector.GraphPoint point5 = new GraphConnector.GraphPoint('E');
        System.out.println(graphConnector.isConnected(point1, point1));
        graphConnector.connect(point1, point2);
        System.out.println(graphConnector.isConnected(point1, point2));
        System.out.println(graphConnector.isConnected(point2, point1));
        System.out.println(graphConnector.isConnected(point1, point3));
        graphConnector.connect(point2, point3);
        System.out.println(graphConnector.isConnected(point1, point3));
    }
}

