package org.vikastaneja.examples;

/**
 * Created by vikastaneja on 3/4/14.
 */
public class BinaryTreeProblems {

    /**
     * Check of the binary tree is balanced binary tree
     * @param root
     * @return
     */
    public static boolean isBalanced(final BinaryTreeNode root) {
        if (root == null) return true;

        int depth = 0;
        int leftDepth = getDepth(root.getLeft(), depth + 1);
        int rightDepth = getDepth(root.getRight(), depth + 1);
        return Math.abs(rightDepth - leftDepth) <= 1;
    }

    /**
     * Get the depth og the binary tree
     * @param node
     * @param depth
     * @return
     */
    private static int getDepth(final BinaryTreeNode node, int depth) {
        if (node == null) return depth;
        if (node.getLeft() == null && node.getRight() == null) return depth;

        depth++;

        return Math.max(getDepth(node.getLeft(), depth), getDepth(node.getRight(), depth));
    }
}
