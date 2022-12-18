package com.leetcode.demo.dec.day18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumIslands4 {

    private static class Element {
        int val;

        public Element(int val) {
            this.val = val;
        }
    }

    private static class UnionFind {
        Map<Integer, Element> elementMap;
        Map<Element, Element> fatherMap;
        Map<Element, Integer> sizeMap;
        int count = 0;

        public UnionFind(char[][] grid, int rows, int columns) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * columns + j;
                        Element element = new Element(index);
                        elementMap.put(index, element);
                        fatherMap.put(element, element);
                        sizeMap.put(element, 1);
                        count++;
                    }
                }
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

        private boolean isSameSet(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                return findHead(elementMap.get(index1)) == findHead(elementMap.get(index2));
            }
            return false;
        }

        private void union(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                Element index1F = findHead(elementMap.get(index1));
                Element index2F = findHead(elementMap.get(index2));

                if (index1F != index2F) {
                    Element bigEle = sizeMap.get(index1F) > sizeMap.get(index2F) ? index1F : index2F;
                    Element smallEle = bigEle == index1F ? index2F : index1F;

                    fatherMap.put(smallEle, bigEle);
                    sizeMap.put(bigEle, sizeMap.get(smallEle) + sizeMap.get(bigEle));
                    sizeMap.remove(smallEle);
                    count--;
                }
            }
        }

        private int getCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(new NumIslands4().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;
        UnionFind unionFind = new UnionFind(grid, rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * columns + j, (i - 1) * columns + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        unionFind.union(i * columns + j, (i + 1) * columns + j);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * columns + j, i * columns + j - 1);
                    }
                    if (j + 1 < columns && grid[i][j + 1] == '1') {
                        unionFind.union(i * columns + j, i * columns + j + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }
}
