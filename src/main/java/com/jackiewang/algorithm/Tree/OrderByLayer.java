package com.jackiewang.algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderByLayer {


    public static List<List<Integer>> printByLayer(Node root) {

        if (root == null) {
            List<List<Integer>> arrayList= new ArrayList<>();
            return arrayList;
        };
        if (root.left == null && root.right == null) {
            List<List<Integer>> arrayList= new ArrayList<>();
            List<Integer> valueList = new ArrayList<>();
            valueList.add(root.value);
            arrayList.add(valueList);
            return arrayList;
        }
        List<List<Integer>> arrayList= new ArrayList<>();
        List<Integer> valueList = null;

        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        int curlayer = 1;
        int nextLayer = 0;
        valueList = new ArrayList<>();
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.left != null){
                queue.add(cur.left);
                nextLayer++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextLayer++;
            }
            if(curlayer > 0) {
                curlayer--;
                valueList.add(cur.value);
                System.out.println(cur.value);
            }

            if(curlayer == 0) {
                arrayList.add(valueList);
                valueList = null;
                curlayer = nextLayer;
                nextLayer = 0;
                valueList = new ArrayList<>();
            }
        }
        return arrayList;

    }
    public static List<List<Integer>> printByLayer2(Node root) {

        if (root == null) {
            List<List<Integer>> arrayList= new ArrayList<>();
            return arrayList;
        };
        List<List<Integer>> arrayList= new ArrayList<>();

        Queue<Node> queue= new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> valueList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                valueList.add(cur.value);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            arrayList.add(valueList);
        }
        return arrayList;

    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(24);
        //System.out.println(printByLayer(node));
        System.out.println(printByLayer2(node));
    }
}
