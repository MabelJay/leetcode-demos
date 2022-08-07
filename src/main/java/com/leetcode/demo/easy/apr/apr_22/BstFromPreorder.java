package com.leetcode.demo.easy.apr.apr_22;

import com.leetcode.demo.easy.TreeNode;

public class BstFromPreorder {

    public static void main(String[] args) {
        // 输入：preorder = [8,5,1,7,10,12]
        //输出：[8,5,10,1,7,null,12]

        int[] preOrder = {8, 5, 1, 7, 10, 12};

        // [4,2]
        int[] preOrder2 = {4, 2};
        System.out.println(new BstFromPreorder().bstFromPreorder(preOrder2));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1, 0);
    }

    public TreeNode buildTree(int[] preOrder, int left, int right, int rootIndex) {
        if (rootIndex < 0 || rootIndex >= preOrder.length || left > right) return null;
        TreeNode root = new TreeNode(preOrder[rootIndex]);
        if (left == right) return root;
        int index = rootIndex + 1;
        while (index <= right && preOrder[index] < preOrder[rootIndex]) index++;
        left = index - 1;
        while (index <= right && preOrder[index] > preOrder[rootIndex]) index++;
        right = index - 1;
        root.left = buildTree(preOrder, rootIndex + 1, left, rootIndex + 1);
        root.right = buildTree(preOrder, left + 1, right, left + 1);
        return root;
    }
}
