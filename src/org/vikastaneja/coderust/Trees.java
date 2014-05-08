package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;
import org.vikastaneja.examples.Intervals;

import java.util.List;
import java.util.Stack;

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

    public static void mergeIntervals(List<Intervals> intervals) {
        if (intervals == null) {
            throw new RuntimeException("List of intervals can't be null");
        }

        if (intervals.size() <= 1) {
            System.out.println("No need for processing the list");
            return;
        }

        // Commenting this until sort is available for Interval class
        // Collections.sort(intervals);

        Stack<Intervals> stack = new Stack<Intervals>();
        for (Intervals interval : intervals) {
            if (stack.empty()) {
                stack.push(interval);
                continue;
            }

            Intervals temp = stack.pop();
            if (temp.end < interval.start) {
                stack.push(temp);
                stack.push(interval);
            } else {
                temp.end = (interval.end > temp.end) ? interval.end : temp.end;
                stack.push(temp);
            }
        }

        // Now stack contain all merged intervals
        intervals.clear();
        while(!stack.empty()) {
            intervals.add(0, stack.pop());
        }
    }

}
