package com.leetcode.demo.easy.jan.jan_19;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    public static void main(String[] args) {
        System.out.println(new GenerateTrees().generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode tmpNode = new TreeNode(i);
            getTrees(n, i - 1, tmpNode, i);
            getTrees(n, i + 1, tmpNode, 1);
            list.add(tmpNode);
        }
        System.out.println(list.size());
        return list;
    }

    public TreeNode getTrees(int n, int index, TreeNode root, int cur) {
        if (root == null) return null;
        if (index <= 0 || index > n) return null;
        if (index < cur) {
            root.left = new TreeNode(index);
            return getTrees(n, index - 1, root.left, index);
        } else {
            root.right = new TreeNode(index);
            return getTrees(n, index + 1, root.right, index);
        }
    }
}
