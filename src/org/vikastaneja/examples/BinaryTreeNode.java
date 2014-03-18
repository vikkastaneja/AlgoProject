package org.vikastaneja.examples;

/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/8/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public final class BinaryTreeNode {
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int value;

    public BinaryTreeNode() {
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(final BinaryTreeNode left, final BinaryTreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public void setLeft(final BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(final BinaryTreeNode right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }

    public int getValue() {
        return this.value;
    }
}
