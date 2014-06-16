package org.vikastaneja.examples;

import java.util.*;

/**
 * Created by vikastaneja on 6/5/14.
 */
public class Node {
   
    public boolean Visited;
    public List<Node> Neighbors;
    public int Value;
    
    public Node(int value) {
        this.Node(new List<Node>(), value);
    }
    
    public Node(List<Node> neighbors, int value) {
        this.Neighbors = neighbors;
        this.Value = value;
        this.Visited = false;
    }
    
    private Node() {
    }
}
