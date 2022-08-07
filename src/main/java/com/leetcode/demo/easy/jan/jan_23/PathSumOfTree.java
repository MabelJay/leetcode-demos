package com.leetcode.demo.easy.jan.jan_23;

import com.leetcode.demo.easy.TreeNode;

import java.util.*;

public class PathSumOfTree {

    public static void main(String[] args) {
        // 输入：root = [1,2,3], targetSum = 5
        //输出：[]

        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        //输出：[[5,4,11,2],[5,8,4,5]]
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        TreeNode node11 = new TreeNode(-2);
        TreeNode node12 = new TreeNode(-3);
        node11.right = node12;

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node4.left = node7;
        node4.right = node8;

        node3.left = node5;
        node3.right = node6;
        node6.left = node9;
        node6.right = node10;

        System.out.println(new PathSumOfTree().pathSum2(null, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs2(root, targetSum, list, new ArrayList<>());
        return list;
    }

    public void dfs(TreeNode root, int target, List<List<Integer>> list, List<Integer> combine) {
        if (root == null) return;
        if (target == root.val && root.left == null && root.right == null) {
            combine.add(root.val);
            list.add(new ArrayList<>(combine));
            combine.remove(combine.size() - 1);
            return;
        }

        combine.add(root.val);
        dfs(root.left, target - root.val, list, combine);
        dfs(root.right, target - root.val, list, combine);
        combine.remove(combine.size() - 1);
    }

    public void dfs2(TreeNode root, int target, List<List<Integer>> list, List<Integer> combine) {
        if (root == null) return;
        combine.add(root.val);

        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(combine));
        }

        dfs2(root.left, target, list, combine);
        dfs2(root.right, target, list, combine);
        combine.remove(combine.size() - 1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Map<TreeNode, TreeNode> pathMap = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> sumQueue = new LinkedList<>();

        queue.offer(root);
        sumQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            int resSum = sumQueue.poll() + tmpNode.val;

            if (tmpNode.left == null && tmpNode.right == null) {
                if (resSum == targetSum) {
                    getPath(tmpNode, pathMap, list);
                }
            } else {
                if (tmpNode.left != null) {
                    pathMap.put(tmpNode.left, tmpNode);
                    queue.offer(tmpNode.left);
                    sumQueue.offer(resSum);
                }

                if (tmpNode.right != null) {
                    pathMap.put(tmpNode.right, tmpNode);
                    queue.offer(tmpNode.right);
                    sumQueue.offer(resSum);
                }
            }
        }
        return list;
    }

    public void getPath(TreeNode node, Map<TreeNode, TreeNode> pathMap, List<List<Integer>> resList) {
        List<Integer> tmpList = new ArrayList<>();
        while (node != null) {
            tmpList.add(node.val);
            node = pathMap.get(node);
        }

        Collections.reverse(tmpList);
        resList.add(new ArrayList<>(tmpList));
    }
}
