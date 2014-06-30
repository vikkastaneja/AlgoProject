package org.vikastaneja.examples;

/**
 * Created by vikastaneja on 3/18/14.
 */
public class ArrayProblems {
    private static void reverse(int []a, int start, int end) {
        if (a == null || a.length <= 1) return;
        if (start > end) return;

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Move all zero numbers to the end.<br/>
     * Strategy is to keep two pointers - current and forward.<br/>
     * Current - to keep the next zero position to fill<br/>
     * Forward - to identify next non-zero position to be filled to current.
     * @param a Array to be processed.
     */
    public static void moveZeroesToEnd(int []a) {
        if (a == null) {
            throw new NullPointerException("Null array is passed");
        }

        if (a.length <= 1)
            return;

        int current = 0;
        int forward = 0;
        while (current < a.length && forward < a.length) {
            while (current < a.length && a[current] != 0)
                current++;

            if (current == a.length)
                break;

            if (current >= forward) forward = current + 1;
            while (forward < a.length && a[forward] == 0) forward++;

            if (forward == a.length) break;

            a[current] = a[forward];
            a[forward] = 0;
            current++;
            forward++;
        }
    }

    public static void circularMove(int[] a, int n) {
        if (a == null || a.length <= 1) return;
        if (n <= 0) return;
        if ( n > a.length) throw new RuntimeException("n is more than length of the array");
        reverse(a, 0, a.length-1);
        reverse(a, 0, a.length-1-n);
        reverse(a, a.length-n, a.length-1);
    }
}
