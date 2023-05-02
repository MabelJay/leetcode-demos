package com.leetcode.demo.apr.day15;

import com.leetcode.demo.sep_10.Jump;

import java.util.*;

public class NumIslands {

    private static class Element {
        int val;

        Element(int val) {
            this.val = val;
        }
    }

    private static class UnionFind {
        Map<Element, Element> parentMap;
        Map<Element, Integer> rankMap;
        Map<Integer, Element> elementMap;
        int count = 0;

        UnionFind(char[][] grid, int rows, int columns) {
            elementMap = new HashMap<>();
            parentMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * columns + j;
                        Element element = new Element(index);
                        elementMap.put(index, element);
                        parentMap.put(element, element);
                        rankMap.put(element, 1);
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

        private void union(int index1, int index2) {
            if (elementMap.containsKey(index1) && elementMap.containsKey(index2)) {
                Element index1P = findParent(elementMap.get(index1));
                Element index2P = findParent(elementMap.get(index2));

                if (index1P != index2P) {
                    Element bigEle = rankMap.get(index1P) > rankMap.get(index2P) ? index1P : index2P;
                    Element smallEle = bigEle == index1P ? index2P : index1P;
                    parentMap.put(smallEle, bigEle);
                    rankMap.put(bigEle, rankMap.get(smallEle) + rankMap.get(bigEle));
                    rankMap.remove(smallEle);
                    count--;
                }
            }
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
//        printMatrix(grid);
        System.out.println(new NumIslands().numIslands(grid));
    }

    private static char[][] getMatrix(String str, int rows, int columns) {
        char[][] grid = new char[rows][columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index > str.length() - 1) return grid;
                grid[i][j] = str.charAt(index++);
            }
        }
        return grid;
    }

    private static void printMatrix(char[][] grid) {
        for (char[] rows : grid) {
            System.out.println(Arrays.toString(rows));
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
        return unionFind.count;
    }
}
