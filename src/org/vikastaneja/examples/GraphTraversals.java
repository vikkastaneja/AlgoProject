package org.vikastaneja.examples;

/**
 * Created by vikastaneja on 06/05/2014
 */
public class GraphTraversals {

    public static void depthFirstTraversal(Node node) {
        if (node == null) {
            throw new NullPointerException();
        }
        
        // Mark this node as visited
        if (!node.Visited) {
            node.Visited = true;
            System.out.print(node.Value + " ");
        }
        
        for (Node n : node.Neighbors) {
            depthFirstTraversal(n);
        }
    }
}
        