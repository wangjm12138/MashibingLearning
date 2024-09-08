package com.jackiewang.algorithm.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Node {
    public int value;
    public int  in;
    public int out;
    public ArrayList<Node> nextTo;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nextTo = new ArrayList<>();
        edges = new ArrayList<>();
    }


}
