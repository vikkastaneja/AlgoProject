package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/8/13
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
public final class BinarySearchTree {

    private BinaryTreeNode root;
    public void setRoot(final BinaryTreeNode root) {
        Preconditions.checkNotNull(root);
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public boolean checkBST(final BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }

        if (node.getLeft() != null && node.getLeft().getValue() > node.getValue()) {
            return false;
        }

        if (node.getRight() != null && node.getRight().getValue() < node.getValue()) {
            return false;
        }

        return true && checkBST(node.getLeft()) && checkBST(node.getRight());
    }
}
