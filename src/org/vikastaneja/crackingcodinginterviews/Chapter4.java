package org.vikastaneja.crackingcodinginterviews;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikastaneja on 3/10/14.
 */
public class Chapter4 {

    /**
     * Problem 4.9: Given a binary tree, print all paths within the tree for which the sum equals a given number<br/>
     * The strategy is to keep an list that keep track of the path till current node <br/>
     * At each node, traverse in reverse and find if there are paths for which the sum equals given value. If so, print it.
     * @param root
     * @param n
     */
    public static void printSumInBinaryTree(Node root, int n) {
        if (root == null) {
            throw new NullPointerException("Root in null");
        }

        List<Node> list = new ArrayList<Node>();
        printSum(root, list, n, -1);
    }

    /**
     * Helper function for {@link org.vikastaneja.crackingcodinginterviews.Chapter4#printSumInBinaryTree(Node, int)} <br/>
     * This function prints the sum by keeping a list with current path.
     * @param current
     * @param list
     * @param n
     * @param currentDepth
     */
    private static void printSum(Node current, List<Node> list, int n, int currentDepth) {
        if (current == null) return;
        if (list == null) throw new NullPointerException("List is null, please initialize the lit before its use.");
        currentDepth++;
        list.add(currentDepth, current);
        int sum = 0;
        for (int i = currentDepth; i >= 0; i--) {
            sum += list.get(i).value;
            if (sum == n) printArray(list, i, currentDepth);
        }

        printSum(current.left, list, n, currentDepth);
        printSum(current.right, list, n, currentDepth);
    }

    /**
     * Helper function to {@link org.vikastaneja.crackingcodinginterviews.Chapter4#printSum(Node, java.util.List, int, int)}<br/>
     * This function prints the values
     * @param list
     * @param current
     * @param currentDepth
     */
    private static void printArray(List<Node> list, int current, int currentDepth) {
        if (list == null || current >= list.size() || current < 0) {
            return;
        }

        for (int i = current; i <= currentDepth; i++)
            System.out.print(list.get(i).value + " ");

        System.out.println();
    }


    /**
     * Helper function to find if the node is in a subtree<br/>
     * Helper function for {@link org.vikastaneja.crackingcodinginterviews.Chapter4#findLca(Node, Node, Node)}
     * @param node
     * @param child
     * @return
     */
    private static boolean isInSubtree(Node node, Node child) {
        if (node == null) return false;

        if (node == child || node.left == child || node.right == child) return true;
        return isInSubtree(node.left, child) || isInSubtree(node.right, child);
    }

    /**
     * Helper function to find if the node is in left subtree<br/>
     * Helper function for {@link org.vikastaneja.crackingcodinginterviews.Chapter4#findLca(Node, Node, Node)}
     * @param node
     * @param child
     * @return
     */
    private static boolean isLeft(Node node, Node child) {
        return isInSubtree(node.left, child);
    }

    /**
     * Helper function to find if the node is in right subtree<br/>
     * Helper function for {@link org.vikastaneja.crackingcodinginterviews.Chapter4#findLca(Node, Node, Node)}
     * @param node
     * @param child
     * @return
     */
    private static boolean isRight(Node node, Node child) {
        return isInSubtree(node.right, child);
    }

    /**
     * To find the least common ancestor (LCA) of two nodes in binary tree<br/>
     * The logic is: If the two nodes are in different subtrees, then current node is the LCA<br/>
     * Else move to the subtree where nodes are present.
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public static Node findLca(Node root, Node node1, Node node2) {
        if (node1 == null || node2 == null) return null;
        if (root == null)
            throw new NullPointerException("Root in null");

        Node temp = root;
        while (temp != null) {
            if (temp == node1 || temp == node2) return temp;
            Node left = temp.left;
            Node right = temp.right;

            if ((isLeft(temp, node1) && isRight(temp, node2))
                    || (isLeft(temp, node2) && isRight(temp, node1))) {
                return temp;
            } else {
                if (isRight(temp, node1)) {
                    temp = right;
                } else {
                    temp = left;
                }
            }
        }

        return null;
    }

    /**
     * Find the longest increasing subarray like {123457843456786} ==> {3456786}
     * This means first increasing and only one down in the end.
     * @param arr
     * @return integer array
     */
    public static int[] longestIncreasingSubarray(int []arr) {
        Preconditions.checkNotNull(arr);
        Preconditions.checkArgument(arr.length > 0);

        int s = 0;
        int e = 0;
        int ms = -1;
        int ml = -1;
        int t = 0;

        int length = arr.length;
        while (e < length) {
            while (e < length && arr[s] < arr[e]) e++;

            t = e;

            if (t+2 < length && arr[t+1] < arr[e] && arr[t+2] > arr[t+1]) {
                if (ml < t+1 - s)  {
                    ml = t+1 -s;
                    ms = s;
                }
            }

            t++;
            while (t < length && arr[e] > arr[t])  {
                t++;
            }
        }

        if (ms == -1) return null;

        int []ret = new int[ml];
        for (int i = 0, s1 = ms; s1 < ms + ml;) {
            ret[i++] = arr[s1++];
        }

        return ret;
    }

    /**
     * Helper function of {@link org.vikastaneja.crackingcodinginterviews.Chapter4#findAncestor(Node, Node, Node)}<br/>
     * To find out if a node is child of a node.
     * @param root
     * @param child
     * @return
     */
    private static boolean isNodePresent(Node root, Node child) {
        if (child == null) return true;
        if (root == null) return false;
        if (root.left == child && (root.left != null && root.left.value == child.value))
            return true;

        if (root.right == child && (root.right != null && root.right.value == child.value))
            return true;

        return isNodePresent(root.left, child) || isNodePresent(root.right, child);
    }

    /**
     * 4.7: Find the common ancestor of two child nodes
     * @param root
     * @param child1
     * @param child2
     * @return Node that is common ancestor
     */
    public static Node findAncestor(final Node root, final Node child1, final Node child2) {
        if (child1 == null && child2 == null) return null;

        if (root == null) return null;

        if (isNodePresent(root, child1) || isNodePresent(root, child2)) return null;

        boolean ch1left = isNodePresent(root.left, child1);
        boolean ch2left = isNodePresent(root.left, child2);

        if (ch1left && !ch2left) return root;
        if (ch2left && !ch1left) return root;

        if (ch1left)
            return  findAncestor(root.left, child1, child2);
        else
            return findAncestor(root.right, child1, child2);
    }

    /**
     * Helper function for {link Chapter4#isSubtree}
     * @param t1
     * @param t2
     * @return
     */
    private static Node getChildNode(final Node t1, final Node t2) {
        if (t2 == null) return null;
        if (t1 == null && t2 == null) return null;
        if (t2 != null && t1 == null) return null;

        if (t1 == t2 && t1.value == t2.value) return t1;

        Node left = getChildNode(t1.left, t2);
        if (left == null) return getChildNode(t1.right, t2);

        return left;
    }

    /**
     * Find out if t2 is subtree of t1
     * @param t1
     * @param t2
     * @return true if t2 is subtree of t1, false otherwise
     */
    public static boolean isSubtree(final Node t1, final Node t2) {
        Node ch = getChildNode(t1, t2);
        if (ch == null) return false;

        return compareTrees(ch, t2);
    }

    /**
     * Helper function for {link Chapter4#isSubtree}<br/>
     * This function is to compare the two trees.
     * @param n1
     * @param n2
     * @return true if the trees are same.
     */
    private static boolean compareTrees(final Node n1, final Node n2) {
        if (n1 == null && n2 == null) return true;

        if ((n1 == null && n1 != null) || (n1 != null && n2 == null)) return false;

        if (n1 == n2 && n1.value == n2.value) {
            return compareTrees(n1.left, n2.left) && compareTrees(n1.right, n2.right);
        }

        return false;
    }

    /**
     * Print all nodes to a given value
     * @param node
     * @param k
     */
    public static void printAllSums(final Node node, int k) {
        if (node == null) return;

        List<Integer> list = new ArrayList<Integer>();
        findSum(node, k, list);
    }

    /**
     * Helper function for {link Chapter4#printAllSums}
     * @param node
     * @param k
     * @param list
     */
    private static void findSum(Node node, int k, List<Integer> list) {
        if (node == null) return;
        if (list == null) throw new RuntimeException("List is empty");
        list.add(node.value);
        int sum = 0;
        List<Integer> l1 = new ArrayList<Integer>();

        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(i);
            if (sum + temp != k) {
                l1.add(temp);
                sum += temp;
            } else {
                l1.add(temp);
                printList(l1);
            }
        }

        findSum(node.left, k, list);
        findSum(node.right, k, list);
    }

    /**
     * Helper function for {link Chapter4#printAllSums}
     * @param list
     */
    private static void printList(List<Integer> list) {

        if (list == null || list.size() == 0) {
            System.out.println("List is empty");
            return;
        }

        for (int i : list) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
