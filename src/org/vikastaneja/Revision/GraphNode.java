package org.vikastaneja.Revision;

import java.util.List;

/**
 * Created by vikastaneja on 8/5/14.
 */
public class GraphNode {
    private List<GraphNode> peers;
    private int value;
    private boolean visited;
    public GraphNode(int value) {
        this.value = value;
        this.visited = false;
        this.peers = null;
    }

    public void addPeers(List<GraphNode> peers) {
        if (peers == null || peers.size() == 0) {
            return;
        }

        this.peers.addAll(peers);
    }

    public List<GraphNode> getPeers() {
        return this.peers;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
