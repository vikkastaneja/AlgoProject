package org.vikastaneja.IntroToAlgo;

import java.util.List;

/**
 * Created by vikastaneja on 4/7/14.
 */
public class Main {
    public static void main(String[] arguments) {
        NodeWithParent tree = new NodeWithParent();
        tree.value = 1;
        tree.parent = null;

        tree.left = new NodeWithParent();
        tree.left.value = 2;
        tree.left.parent = tree;
        tree.right = new NodeWithParent();
        tree.right.value = 3;
        tree.right.parent = tree;

        tree.left.left = new NodeWithParent();
        tree.left.left.parent = tree.left;

        tree.left.right = new NodeWithParent();
        tree.left.right.parent = tree.left;

        tree.left.left.value = 4;
        tree.left.right.value = 5;

        tree.right.left = new NodeWithParent();
        tree.right.right = new NodeWithParent();

        tree.right.left.parent = tree.right;
        tree.right.right.parent = tree.right;

        tree.right.left.value = 6;
        tree.right.right.value = 7;

        List<Integer> list = Ch10.visitNodes_10_4_4(tree);
    }
}
