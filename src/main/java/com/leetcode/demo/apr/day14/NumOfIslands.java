package com.leetcode.demo.apr.day14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumOfIslands {

    private static class Element {
        int val;

        Element(int val) {
            this.val = val;
        }
    }

    private static class UnionFind {
        Map<Integer, Element> elementMap;
        Map<Element, Element> parentMap;
        Map<Element, Integer> sizeMap;
        int count = 0;

        UnionFind(char[][] grid, int rows, int columns) {
            elementMap = new HashMap<>();
            parentMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * columns + j;
                        Element element = new Element(index);
                        elementMap.put(index, element);
                        parentMap.put(element, element);
                        sizeMap.put(element, 1);
                        count++;
                    }
                }
            }
        }

        private Element findParent(Element element) {
            LinkedList<Element> stack = new LinkedList<>();
            while (element != parentMap.get(element)) {
                stack.push(element);
                element = parentMap.get(element);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), element);
            }
            return element;
        }

        private boolean isSameSet(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                return findParent(elementMap.get(index1)) == findParent(elementMap.get(index2));
            }
            return false;
        }

        private void union(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                Element index1P = parentMap.get(elementMap.get(index1));
                Element index2P = parentMap.get(elementMap.get(index2));

                if (index1P != index2P) {
                    Element bigEle = sizeMap.get(index1P) > sizeMap.get(index2P) ? index1P : index2P;
                    Element smallEle = bigEle == index1P ? index2P : index1P;
                    parentMap.put(smallEle, bigEle);
                    sizeMap.put(bigEle, sizeMap.get(smallEle) + sizeMap.get(bigEle));
                    sizeMap.remove(smallEle);
                    count--;
                }
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // 输入：grid = [
        //  ["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]
        //]
        //输出：3
        char[][] grid = getMatrix("11000110000010000011", 4, 5);
        System.out.println(new NumOfIslands().numIslands(grid));
//        printMatrix(grid);
    }

    private static char[][] getMatrix(String s, int rowNum, int columnNum) {
        char[][] grid = new char[rowNum][columnNum];
        int index = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (index > s.length() - 1) return grid;
                grid[i][j] = s.charAt(index++);
            }
        }
        return grid;
    }

    private static void printMatrix(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
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
