package com.jackiewang.algorithm.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializeTree {
    public static List<String> result = new ArrayList<>();
    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null)
            return "#";
        process(root);
        String res = result.stream().collect(Collectors.joining(", "));
        return res;
    }

    private static void process(Node root) {
        if(root == null) {
            result.add("#");
            return;
        }
        result.add(String.valueOf(root.value));
        process(root.left);
        process(root.right);
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if (data.equals("#"))
            return null;
        String[] arr = data.split(",");
        Queue<String> queue = Stream.of(arr).map((item)->item.trim()).collect(Collectors.toCollection(LinkedList::new));

        return create(queue);
    }

    private static Node create(Queue<String> queue) {
        String O = queue.poll();
        if (O.equals("#") || queue.isEmpty()) {
            return null;
        }
        Node node = new Node(Integer.parseInt(O));
        node.left = create(queue);
        node.right = create(queue);
        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(24);
        String res = serialize(node);
        Node root = deserialize(res);
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.right.value);
        System.out.println(root.left.left.value);
        System.out.println(root.left.right.value);
        System.out.println(root.right.left.value);
        System.out.println(root.right.right.value);

    }
}
