package com.leetcode.demo.dec.day18;

public class FindCircleNum {

    private static class UnionFind {
        int[] parent;
        int[] sizeArr;
        int count;

        public UnionFind(int[][] isConnected, int length) {
            count = 0;
            parent = new int[length];
            sizeArr = new int[length];

            for (int i = 0; i < length; i++) {
                parent[i] = i;
                sizeArr[i]++;
                count++;
            }
        }

        public int findHead(int index) {
            if (parent[index] != index) {
                parent[index] = findHead(parent[index]);
            }
            return parent[index];
        }

        public void union(int index1, int index2) {
            int index1F = findHead(index1);
            int index2F = findHead(index2);

            if (index1F != index2F) {
                int bigElement = sizeArr[index1F] >= sizeArr[index2F] ? index1F : index2F;
                int smallElement = bigElement == index1F ? index2F : index1F;
                parent[smallElement] = bigElement;
                sizeArr[bigElement] += sizeArr[smallElement];
                sizeArr[smallElement] = 0;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        //输出：2

        // [[1,1,1],[1,1,1],[1,1,1]]
        // 1
        int[][] isConnected = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(new FindCircleNum().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int len = isConnected.length;
        UnionFind unionFind = new UnionFind(isConnected, len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }
}
