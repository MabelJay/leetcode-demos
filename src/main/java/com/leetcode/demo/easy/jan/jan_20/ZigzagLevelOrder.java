package com.leetcode.demo.easy.jan.jan_20;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        //输出：[[3],[20,9],[15,7]]


        // [1,2,3,4,null,null,5]
        // [[1],[3,2],[4,5]]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(node1));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean moveLeft = true;
        int levelCount;
        while (!queue.isEmpty()) {
            levelCount = queue.size();
            List<Integer> tmpList = new ArrayList<>();

            while (levelCount > 0) {
                levelCount--;
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            if (!moveLeft) {
                Collections.reverse(tmpList);
            }
            moveLeft = !moveLeft;
            list.add(tmpList);
        }
        return list;
    }
}
