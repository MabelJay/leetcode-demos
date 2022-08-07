package com.leetcode.demo.easy.may.may_02;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        //输出：[[5,4,11,2],[5,8,4,5]]

        // 输入：root = [1,2,3], targetSum = 5
        //输出：[]

        // 5 4 8 2 13 9

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        System.out.println(new PathSum().pathSum(node1, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root, resList, new ArrayList<>(), targetSum);
        return resList;
    }

    public void dfs(TreeNode root, List<List<Integer>> resList, List<Integer> tmpList, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum == root.val) {
            tmpList.add(root.val);
            resList.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        tmpList.add(root.val);
        dfs(root.left, resList, tmpList, targetSum - root.val);
        dfs(root.right, resList, tmpList, targetSum - root.val);
        tmpList.remove(tmpList.size() - 1);
    }
}
