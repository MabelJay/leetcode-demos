package com.leetcode.demo.easy.june.june_13;

public class MyCalendar3 {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int start;
        int end;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public TreeNode() {
        }
    }

    TreeNode root;

    public MyCalendar3() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }

        TreeNode p = root;
        while (true) {
            if (end <= p.start) {
                if (p.left == null) {
                    p.left = new TreeNode(start, end);
                    return true;
                }
                p = p.left;
            } else if (start >= p.end) {
                if (p.right == null) {
                    p.right = new TreeNode(start, end);
                    return true;
                }
                p = p.right;
            } else return false;
        }
    }
}
