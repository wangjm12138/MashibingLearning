package com.jackiewang.algorithm.Tree;


import org.springframework.expression.spel.ast.NullLiteral;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree {
    public Node root = null;
    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if(Math.random() > 0.5) {
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
    public void printTree() {
//        if (this.root == null) {
//            return;
//        }
//        Queue<Node> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//        while (!nodeQueue.isEmpty()) {
//            int size = nodeQueue.size();
//            for(int i=0; i < size; i++) {
//                Node node = nodeQueue.poll();
//                if(node==null)
//                {
//                    System.out.print("null" + " ");
//                } else {
//                    System.out.print(node.value + " ");
//                    if (node.left != null) {
//                        nodeQueue.add(node.left);
//                    } else {
//                        nodeQueue.add(null);
//                    }
//                    if (node.right != null) {
//                        nodeQueue.add(node.right);
//                    } else {
//                        nodeQueue.add(null);
//                    }
//                }
//            }
//            System.out.println();
//        }
        if (this.root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for(int i=0; i < size; i++) {
                Node node = nodeQueue.poll();
                if(node!=null)
                {
                    System.out.print(node.value + " ");
                    if (node.left != null) {
                        nodeQueue.add(node.left);
                    }
                    if (node.right != null) {
                        nodeQueue.add(node.right);
                    }
                }
            }
            System.out.println();
        }
    }

    public int printDepth(Node root){
        if (root == null) return 0;


        return Math.max(printDepth(root.left), printDepth(root.right))+1;
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
        binaryTree.printTree();

//        binaryTree.pre(binaryTree.root);
//        System.out.println();
//        System.out.println(binaryTree.printDepth(binaryTree.root));
//        binaryTree.in(binaryTree.root);
//        System.out.println();
//        binaryTree.post(binaryTree.root);
//        System.out.println();
    }


}
