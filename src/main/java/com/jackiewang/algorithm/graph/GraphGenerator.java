package com.jackiewang.algorithm.graph;

public class GraphGenerator {

    // weight, from 节点上的值， to 节点上的值
    // [[5, 0, 7]
    // [3, 0, 1]
    // ...]
    //
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for(int i=0; i< matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(matrix[i][0], fromNode, toNode);
            fromNode.nextTo.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

}
