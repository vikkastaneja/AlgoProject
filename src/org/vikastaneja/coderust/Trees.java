package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;
import org.vikastaneja.examples.Intervals;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by vikastaneja on 3/31/14.
 */
public class Trees {
	private static int nth;
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
	
    public static int deleteZeroSum(Node tree) {
        if (tree == null) return 0;
        int left = deleteZeroSum(tree.left);
        int right = deleteZeroSum(tree.right);

        if (left == 0) tree.left = null;
        if (right == 0) tree.right = null;
        return left + right + tree.value;
    }

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
}
