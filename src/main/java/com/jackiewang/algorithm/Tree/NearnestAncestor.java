package com.jackiewang.algorithm.Tree;

public class NearnestAncestor {

    static class Info {
        boolean LessContainsP;
        boolean LessContainsQ;
        Node Ancestor;
        public Info(boolean lessP, boolean lessQ, Node ancestor) {
            this.LessContainsP = lessP;
            this.LessContainsQ = lessQ;
            this.Ancestor = ancestor;
        }
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        return process(root, p, q).Ancestor;
    }

    public static Info process(Node root, Node p, Node q){
        if(root == null) {
            return new Info(false,false, null);
        }
        Info left = process(root.left, p, q);
        Info right = process(root.right, p, q);
//        System.out.println("-----");
//        System.out.println(left.LessContainsP);
//        System.out.println(left.LessContainsQ);
//        //System.out.println(left.Ancestor);
//        System.out.println(right.LessContainsP);
//        System.out.println(right.LessContainsQ);
//        System.out.println(root.value);
//        System.out.println("------");


        boolean LessContainsP = false;
        boolean LessContainsQ = false;
        Node Ancestor = null;

        if(left.LessContainsP || right.LessContainsP || root.value == p.value) {
            LessContainsP = true;
        }
        if(left.LessContainsQ || right.LessContainsQ || root.value == q.value) {
            LessContainsQ = true;
        }
        if(left.Ancestor != null) {
            Ancestor = left.Ancestor;
        } else if(right.Ancestor != null) {
            Ancestor = right.Ancestor;
        } else {
            if(LessContainsQ && LessContainsP) {
                Ancestor = root;
            }
        }

        return new Info(LessContainsP,LessContainsQ, Ancestor);
    }

    public static void main(String[] args) {
//        Node node = new Node(10);
//        node.left = new Node(5);
//        node.right = new Node(20);
//        node.left.left = new Node(4);
//        node.left.right = new Node(6);
//        node.right.left = new Node(8);
//        node.right.right = new Node(24);

        Node node = new Node(37);
        //node.left = new Node(-34);
        node.right = new Node(-48);
        //node.left.right = new Node(-100);
        node.right.left = new Node(-101);
        node.right.right = new Node(48);
        node.right.right.left = new Node(-71);
        node.right.right.right = new Node(-22);

        Node p = new Node(-101);
        Node q = new Node(-71);
        System.out.println(lowestCommonAncestor(node, p, q).value);

    }
}
