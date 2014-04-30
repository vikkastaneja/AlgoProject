package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;

/**
 * Created by vikastaneja on 4/8/14.
 */
public class Main {
    public static void main(String[] args) {
        Node tree = new Node();
        tree.value = 2;
        tree.left = new Node();
        tree.left.value = 3;
        tree.right = new Node();
        tree.right.value = 5;
        tree.left.left = new Node();
        tree.left.left.value = -1;
        tree.left.right = new Node();
        tree.left.right.value = 2;
        tree.left.right.left = new Node();
        tree.left.right.left.value = -1;
        tree.left.right.right = new Node();
        tree.left.right.right.value = -3;

        Trees.deleteZeroSum(tree);
    }
}
