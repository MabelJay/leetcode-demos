package com.leetcode.demo.easy.jan.jan_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {

    int sum = 0;

    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        //输出：25
        //从根到叶子节点路径 1->2 代表数字 12
        //从根到叶子节点路径 1->3 代表数字 13
        //因此，数字总和 = 12 + 13 = 25

        // 输入：root = [4,9,0,5,1]
        //输出：1026
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(1);

        node4.left = node5;
        node4.right = node6;
        node5.left = node7;
        node5.right = node8;
        System.out.println(new SumNumbers().sumNumbers(node4));
    }

    public int sumNumbers(TreeNode root) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, resList, sb);

        int res = 0;
        for (String s : resList) {
            res += Integer.parseInt(s);
        }

        dfs(root, new StringBuilder());
        System.out.println(sum);

        System.out.println("dfs3= " + dfs(root, 0));
        return res;
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) return 0;
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public void dfs(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(root.val);
        dfs(root.left, list, sb);
        dfs(root.right, list, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
