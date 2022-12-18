package com.leetcode.demo.dec.day18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindCircleNum2 {

    private static class Element {
        int val;

        public Element(int val) {
            this.val = val;
        }
    }

    private static class UnionFind {
        int count;
        Map<Integer, Element> elementMap;
        Map<Element, Element> fatherMap;
        Map<Element, Integer> sizeMap;

        public UnionFind(int[][] isConnected, int cities) {
            count = 0;
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (int i = 0; i < cities; i++) {
                count++;
                Element element = new Element(i);
                elementMap.put(i, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element findHead(Element element) {
            LinkedList<Element> stack = new LinkedList<>();

            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }

            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        private void union(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                Element index1F = findHead(elementMap.get(index1));
                Element index2F = findHead(elementMap.get(index2));

                if (index1F != index2F) {
                    Element bigEle = sizeMap.get(index1F) > sizeMap.get(index2F) ? index1F : index2F;
                    Element smallEle = bigEle == index1F ? index2F : index1F;

                    fatherMap.put(smallEle, bigEle);
                    sizeMap.put(bigEle, sizeMap.get(bigEle) + sizeMap.get(smallEle));
                    sizeMap.remove(smallEle);
                    count--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(new FindCircleNum2().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int cities = isConnected.length;
        UnionFind unionFind = new UnionFind(isConnected, cities);
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }
}
