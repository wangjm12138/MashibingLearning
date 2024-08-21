package com.jackiewang.algorithm.Tree;

public class CalculateDepth {

    public static int calculateDepth(Node root) {
        if (root == null) return 0;

        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(24);
        System.out.println(calculateDepth(node));
    }
}
