package com.leetcode.demo.easy;

import java.util.*;

public class MultiTreePreorder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        //root = [1,null,3,2,4,null,5,6]
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> children = new ArrayList<>();
        children.add(node2);
        children.add(node3);
        children.add(node4);
        node1.children = children;

        List<Node> child2 = new ArrayList<>();
        child2.add(node5);
        child2.add(node6);

        node2.children = child2;

        System.out.println(new MultiTreePreorder().postorder(node1));
        System.out.println(new MultiTreePreorder().postorder2(node1));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    public void traverse(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        List<Node> childList = root.children;
        if (childList != null) {
            for (Node node : childList) {
                traverse(node, list);
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            list.add(tmpNode.val);
            List<Node> children = tmpNode.children;
            if (children != null) {
                Collections.reverse(children);
                for (Node node : children) {
                    stack.push(node);
                }
            }
        }
        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        postorderTraverse(root, list);
        return list;
    }

    public void postorderTraverse(Node root, List<Integer> list) {
        if (root == null) return;
        List<Node> children = root.children;
        if (children != null) {
            for (Node node : children) {
                postorderTraverse(node, list);
            }
        }
        list.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<Node> stack1 = new LinkedList<>();
        Deque<Node> stack2 = new LinkedList<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node tmpNode = stack1.pop();
            stack2.push(tmpNode);
            List<Node> children = tmpNode.children;
            if (children != null) {
                for (Node node : children) {
                    stack1.push(node);
                }
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
