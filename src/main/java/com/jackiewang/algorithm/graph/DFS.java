package com.jackiewang.algorithm.graph;

import java.util.*;

public class DFS {

    public static void DFS(Node from) {
        if(from == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(from);
        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(from);
        while (!stack.isEmpty()){

            Node node = stack.pop();

            for (int j = 0; j < node.nextTo.size(); j++) {
                Node nextNode = node.nextTo.get(j);
                if (!nodeSet.contains(nextNode)) {
                    stack.push(node);
                    stack.push(nextNode);
                    nodeSet.add(nextNode);
                    System.out.println(nextNode.value);
                    break;
                }
            }

        }
    }

}
