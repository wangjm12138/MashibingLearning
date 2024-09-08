package com.jackiewang.algorithm.graph;

import java.util.*;

public class BFS {

    public static void BFS(Node from) {
        if(from == null)
            return;
        //Collection<Node> allNodes = graph.nodes.values();
        Queue<Node> queue = new LinkedList<>();
        queue.add(from);
        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(from)
        while (!queue.isEmpty()){
            for (int i=0;i<queue.size();i++){
                Node node = queue.poll();
                System.out.println(node.value);
                for (int j = 0; j < node.nextTo.size(); j++) {
                    Node nextNode = node.nextTo.get(j);
                    if(!nodeSet.contains(nextNode)) {
                        queue.add(node.nextTo.get(j));
                    }
                }
            }

        }
    }

}
