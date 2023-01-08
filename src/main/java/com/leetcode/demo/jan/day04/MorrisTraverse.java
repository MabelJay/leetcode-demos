package com.leetcode.demo.jan.day04;

public class MorrisTraverse {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

//        morris(node1);
//        preorderInMorris(node1);
//        inorder(node1);
        postorder(node1);
    }

    public static void morris(TreeNode node) {
        if (node == null) return;

        TreeNode cur = node;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            System.out.println(cur.val);
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void preorderInMorris(TreeNode node) {
        if (node == null) return;

        TreeNode cur = node;
        TreeNode mostRight;

        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val);
            }
//            System.out.println("cur=" + cur.val);
            cur = cur.right;
        }
    }

    public static void inorder(TreeNode node) {
        if (node == null) return;

        TreeNode cur = node;
        TreeNode mostRight;

        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static void postorder(TreeNode node) {
        if (node == null) return;

        TreeNode cur = node;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right != null) {
                    mostRight.right = null;
                    printEdge(cur.left);
                } else {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
            }
            cur = cur.right;
        }
        printEdge(node);
    }

    private static void printEdge(TreeNode node) {
        TreeNode tail = reverseEdge(node);
        TreeNode tmpNode = tail;
        while (tmpNode != null) {
            System.out.println(tmpNode.val);
            tmpNode = tmpNode.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode cur = from;

        while (cur != null) {
            TreeNode right = cur.right;
            cur.right = pre;
            pre = cur;
            cur = right;
        }
        return pre;
    }
}
