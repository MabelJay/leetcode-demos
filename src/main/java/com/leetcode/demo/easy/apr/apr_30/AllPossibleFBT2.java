package com.leetcode.demo.easy.apr.apr_30;

import com.leetcode.demo.easy.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT2 {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public static void main(String[] args) {

        List<TreeNode> ans = new AllPossibleFBT2().allPossibleFBT(7);
        for (TreeNode node : ans) {
            System.out.println(node.val);
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (!map.containsKey(n)) {
            List<TreeNode> list = new LinkedList<>();
            if (n == 1) {
                list.add(new TreeNode(0));
            } else if (n % 2 != 0) {
                for (int x = 0; x < n; x++) {
                    int y = n - 1 - x;
                    for (TreeNode left : allPossibleFBT(x)) {
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }
            }
            map.put(n, list);
        }
        return map.get(n);
    }
}
