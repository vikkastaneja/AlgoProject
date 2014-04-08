package org.vikastaneja.IntroToAlgo;

/**
 * Created by vikastaneja on 4/7/14.
 */
public class NodeWithParent {
    public Integer value;
    public NodeWithParent left;
    public NodeWithParent right;
    public NodeWithParent parent;

    public NodeWithParent() {
        left = right = parent = null;
    }
}
