package org.vikastaneja.Misc;

/**
 * Created by vikastaneja on 7/27/14.
 */
public class MiscExamples {
    // Node for doubly linked list
    public class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node (int n) {
            value = n;
            prev = next = null;
        }
    }

    // Keep track of the header
    private Node head = null;

    // Keep track of the tail
    private Node tail = null;

    // Keep track of the mid of the list
    private Node mid = null;

    // To track if the number of elements in the array are even or odd.
    private boolean even = false;

    // Always store a sorted doubly linked list
    // Also keep the mid and adjust it based on the number of elements in the array

    /**
     * This function adds the input to the object.<br/>
     * Internally, it is adding the values to a doubly linked list in increasing sorted fashion.
     * @param n
     */
    public void getInput(int n)
    {
        Node temp = new Node(n);
        if (head == null) {
            mid = tail = head = temp;
            return;
        }

        if (n <= head.value) {
            temp.next = head;
            head.prev = temp;
            head = temp;
            even = !even;
            if (!even) mid = mid.prev;
            return;
        }

        if (n >= tail.value) {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            even = !even;
            if (even) {
                mid = mid.next;
            }
            return;
        }

        Node t1 = head;

        while (t1 != tail && t1.value < n) {
            t1 = t1.next;
        }

        Node t2 = t1.prev;
        t2.next = temp;
        temp.prev = t2;
        temp.next = t1;
        t1.prev = temp;
        even = !even;
        if (n < mid.value && even) mid = mid.prev;
        else if (n > mid.value && even) mid = mid.next;
        return;
    }


    // function 2
    // Don't have a sum = return false
    // Has a sum of pairs = return true
    // If array is null = throw exception
    // Array has size zero = return false
    // Array has only one element, return false
    // Thread safety is not required
    // Array can have duplicates = handled here

    /**
     * The function finds out if there is a pair exists in the array that has sum equals a given value.
     * @param n - given value
     * @return - true if sum exists, false otherwise
     */
    public boolean hasSum(int n)
    {
        if (head == null)
            throw new NullPointerException("Header not initialized");

        if (head == tail) return false;

        Node f = n < mid.value ? head : mid;
        Node b = n < mid.value ? mid : tail;
        while (f != b) {
            int sum = f.value + b.value;
            if (n == sum) return true;
            else if (n > sum) f = f.next;
            else if (n < sum) b = b.prev;
        }

        return false;
    }

    public static void main(String[] args) {
        MiscExamples ex = new MiscExamples();
        ex.getInput(10);
        ex.getInput(20);
        ex.getInput(5);
        ex.getInput(35);
        ex.getInput(0);
        System.out.println(ex.hasSum(0));
        System.out.println(ex.hasSum(30));
        int [][]a = {{0,0,0,0,0},{0,1,1,1,0},{0,1,0,1,0},{0,1,1,1,0},{0,0,0,0,0}};
        System.out.println("====> " + MatrixProblems.IsGoGameOver(a));
    }
}
