package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by vikastaneja on 3/31/14.
 */
public class Trees {
	private static int nth;

    /**
     * Delete subtrees in a binary tree for a given sum<br/>
     * Idea is to perform DFS. At every node, see if the subtree sum is zero. If it is, then delete the subtree.
     * @param root
     * @param n
     */
    public static void deleteSubtree(Node root, int n) {
        if (root == null)
            throw new NullPointerException("Root is null");

        int sum = deleteFromTree(root, null, n);
        if (sum == n)
            root = null;
    }

    /**
     * Helper function for {@link org.vikastaneja.coderust.Trees#deleteSubtree(org.vikastaneja.crackingcodinginterviews.Node, int)}<br/>
     * The idea is mentioned in the javadocs for main function. Here, we only need an additional parameter - parent of the current node.
     * @param current
     * @param parent
     * @param n
     * @return
     */
    private static int deleteFromTree(Node current, Node parent, int n) {
        if (current == null)
            return 0;

        int sum = current.value +
                    deleteFromTree(current.left, current, n) +
                    deleteFromTree(current.right, current, n);

        if (sum == n) {
            if (parent != null) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }

        return sum;
    }

    /**
     * Print the nth largest node in a binary search tree (BST)
     * @param tree
     * @param n
     */
	public static void printNth(Node tree, int n) {
		if (tree == null) {
			throw new NullPointerException();
		}
		
		if (n <= 0) {
			throw new RuntimeException();
		}
		
		nth = n;
		printNthLargest(tree);
	}
	
	private static void printNthLargest(Node tree) {
		if (tree == null) {
			return;
		}
		
		if (nth > 0) {
			printNthLargest(tree.left);
		}
		
		nth--;
		if (nth == 0) {
			System.out.println(tree.value);
			return;
		}
		
		if (nth > 0) {
			printNthLargest(tree.right);
		}
		
	}

    /**
     * Delete zero sum subtrees
     * @param tree
     * @return
     */
    public static int deleteZeroSum(Node tree) {
        if (tree == null) return 0;
        int left = deleteZeroSum(tree.left);
        int right = deleteZeroSum(tree.right);

        if (left == 0) tree.left = null;
        if (right == 0) tree.right = null;
        return left + right + tree.value;
    }

    /**
     * Traverse the tree level wide.
     * @param root
     */
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            throw new NullPointerException("Root can't be null");
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node temp = queue.remove();

            if (temp == null) {
                System.out.println();
                continue;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
               queue.add(temp.right);
            }
            if (queue.peek() == null) {
                queue.add(null);
            }

            System.out.print(temp.value + " ");
        }

    }

    /**
     * Swap left and right subtrees
     * @param node
     */
    public static void swapLeftRight(Node node) {
        if (node == null) return;
        swapLeftRight(node.left);
        swapLeftRight(node.right);
        Node left = node.left;
        Node right = node.right;
        node.left = right;
        node.right = left;
    }

    /**
     * Helper function for {@link org.vikastaneja.coderust.Trees#printPerimeter(org.vikastaneja.crackingcodinginterviews.Node)}<br/>
     * To print left branch of a tree
     * @param root
     */
    private static void printLeftBranch(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root;
        while (temp.left != null && temp.right != null) {
            System.out.print(temp.value + " ");
            if (temp.left != null) {
                temp = temp.left;
            } else if (temp.right != null) {
                temp = temp.right;
            }
        }
    }

    /**
     * Helper function for {@link org.vikastaneja.coderust.Trees#printPerimeter(org.vikastaneja.crackingcodinginterviews.Node)}<br/>
     * To print left leaves of a tree
     * @param root
     */
    private static void printLeaves(Node root) {
        if (root == null) {
            return;
        }

        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.value + " ");
        }

        printLeaves(root.right);
    }

    /**
     * Helper function for {@link org.vikastaneja.coderust.Trees#printPerimeter(org.vikastaneja.crackingcodinginterviews.Node)}<br/>
     * To print right branch of a tree
     * @param root
     */
    private static void printRightBranch(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root;
        Stack<Node> stack = new Stack<Node>();

        stack.push(temp);
        temp = temp.right;
        while(temp.left != null && temp.right != null) {
            if (temp.right != null) {
                temp = temp.right;
            } else if (temp.left != null) {
                temp = temp.left;
            }

            stack.push(temp);
        }

        while (stack.peek() != root) {
            System.out.print(stack.pop().value + " ");
        }
    }

    /**
     * Print perimeter of a binary tree
     * @param root
     */
    public static void printPerimeter(Node root) {
        if (root == null) {
            System.out.println("Root is null. Hence will not print empty or null tree");
            return;
        }

        printLeftBranch(root);
        printLeaves(root);
        printRightBranch(root);
        System.out.println();
    }
}
