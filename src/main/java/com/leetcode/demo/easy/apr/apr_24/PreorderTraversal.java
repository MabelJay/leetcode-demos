package com.leetcode.demo.easy.apr.apr_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {
        // 输入：root = [1,null,2,3]
        //输出：[1,2,3]

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(new PreorderTraversal().preorderTraversal(node1));
        System.out.println(new PreorderTraversal().preorderTraversal2(node1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        dfs(root, resList);
        return resList;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            resList.add(tmpNode.val);
            if (tmpNode.right != null) stack.push(tmpNode.right);
            if (tmpNode.left != null) stack.push(tmpNode.left);
        }

        return resList;
    }
}
