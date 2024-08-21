package com.jackiewang.algorithm.Tree;


import org.springframework.expression.spel.ast.NullLiteral;

import java.util.Random;

public class BinaryTree {
    public Node root = null;
    public Random random = new Random();
    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if(key < root.value) {
            root.left = insertRecursive(root.left, key);
        } else {
            root.right = insertRecursive(root.right, key);

        }
        return root;
    }


    public void insert(int value){
        root = insertRecursive(root, value);
    }



    public void pre(Node root){
        if (root == null) return;

        System.out.print(root.value + " ");
        pre(root.left);
        pre(root.right);

    }

    public void in(Node root){
        if (root == null) return;

        in(root.left);
        System.out.print(root.value + " ");
        in(root.right);

    }

    public void post(Node root){
        if (root == null) return;

        post(root.left);
        post(root.right);
        System.out.print(root.value + " ");

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(15);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(12);
        binaryTree.insert(17);
        binaryTree.pre(binaryTree.root);
        System.out.println();
        binaryTree.in(binaryTree.root);
        System.out.println();
        binaryTree.post(binaryTree.root);
        System.out.println();
    }


}
