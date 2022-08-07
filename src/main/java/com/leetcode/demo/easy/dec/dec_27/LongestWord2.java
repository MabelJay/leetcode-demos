package com.leetcode.demo.easy.dec.dec_27;

import java.util.HashMap;
import java.util.Stack;

class LongestWord2 {

    public static void main(String[] args) {
        // 输入：
        //words = ["w","wo","wor","worl", "world"]
        //输出："world"

        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWord2().longestWord(words));

        // words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        //输出："apple"

    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word : words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }
}

class Node {
    char c;
    HashMap<Character, Node> children = new HashMap();
    int end;

    public Node(char c) {
        this.c = c;
    }
}

class Trie {
    Node root;
    String[] words;

    public Trie() {
        root = new Node('0');
    }

    // words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    public void insert(String word, int index) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length() ||
                            word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
                for (Node nei : node.children.values()) {
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}