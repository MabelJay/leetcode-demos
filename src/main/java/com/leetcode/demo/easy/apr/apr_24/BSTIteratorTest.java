package com.leetcode.demo.easy.apr.apr_24;

import com.leetcode.demo.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIteratorTest {

    static class BSTIterator {

        List<Integer> list;
        int index;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root, list);
            index = 0;
        }

        public void dfs(TreeNode root, List<Integer> list) {
            if (root == null) return;
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }

        public int next() {
            if (hasNext()) {
                return list.get(index++);
            }
            return -1;
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }

    public static void main(String[] args) {
        // 输入
        //["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
        //[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
        //输出
        //[null, 3, 7, true, 9, true, 15, true, 20, false]
/*
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        BSTIterator iterator = new BSTIterator(node1);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
*/


        // 输入：
        //["BSTIterator","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
        //[[[3,1,4,null,2]],[],[],[],[],[],[],[],[],[]]
        //输出：
        //[null,true,1,true,3,true,4,false,-1,false]
        //预期结果：
        //[null,true,1,true,2,true,3,true,4,false]

        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(1);
        node6.left = node7;
        node6.right = node8;
        node7.left = node9;

        BSTIterator iterator1 = new BSTIterator(node6);
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
    }
}
