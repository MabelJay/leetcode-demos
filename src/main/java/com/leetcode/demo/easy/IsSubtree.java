package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSubtree {

    List<Integer> sOrder = new ArrayList<Integer>();
    List<Integer> tOrder = new ArrayList<>();
    int maxElement, lNull, rNull;

    public static void main(String[] args) {
        //输入：root = [3,4,5,1,2], subRoot = [4,1,2]
        //输出：true

        //[3,4,5,1,null,2]
        //[3,1,2]

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
//        node5.left = node6;

        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        node7.left = node8;
        node7.right = node9;

        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        node10.left = node11;

        System.out.println(new IsSubtree().isSubtree(node10, node11));
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return dfs(root, subRoot) || isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    public void getMaxElement(TreeNode t) {
        if (t == null) {
            return;
        }
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(lNull);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(rNull);
        }
    }

    public boolean kmp() {
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] fail = new int[tOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < tLen; ++i) {
            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < sLen; ++i) {
            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            if (j == tLen - 1) {
                return true;
            }
        }
        return false;
    }
}
