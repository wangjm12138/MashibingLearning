package com.jackiewang.algorithm.Tree;

//高度不超过1
public class IsBalanced {
    static class Info {
        public boolean isBalanced=true;
        public int height=0;
    }

    public static boolean isBalanced(Node root) {
       return  process(root).isBalanced;
    }

    public static Info process(Node root) {
        if (root == null) return new Info();

        Info left = process(root.left);
        Info right = process(root.right);
        Info info = new Info();

        if (!left.isBalanced) {
            info.isBalanced = false;
            return info;
        }
        if (!right.isBalanced) {
            info.isBalanced = false;
            return info;
        }
        if (Math.abs(left.height - right.height) > 1) {
            info.isBalanced = false;
            return info;
        }
        info.isBalanced = true;
        info.height = Math.max(left.height, right.height) + 1;

        return info;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        //node.right = new Node(20);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        //node.right.left = new Node(8);
        //node.right.right = new Node(24);


        System.out.println(isBalanced(node));
        node.right = new Node(20);
        node.right.left = new Node(8);
        node.right.right = new Node(24);
        System.out.println(isBalanced(node));
    }
}
