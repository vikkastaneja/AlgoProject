package org.vikastaneja.examples;

import java.util.*;

/**
 * Created by vikastaneja on 6/5/14.
 */
public class GraphNode {
   
    public boolean Visited;
    public List<GraphNode> Neighbors;
    public int Value;
    
    public GraphNode(int value) {
        this(new ArrayList<GraphNode>(), value);
    }
    
    public GraphNode(List<GraphNode> neighbors, int value) {
        this.Neighbors = neighbors;
        this.Value = value;
        this.Visited = false;
    }
    
    private GraphNode() {
    }
}
