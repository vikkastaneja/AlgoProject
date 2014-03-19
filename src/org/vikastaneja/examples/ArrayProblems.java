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

    public static void circularMove(int[] a, int n) {
        if (a == null || a.length <= 1) return;
        if (n <= 0) return;
        if ( n > a.length) throw new RuntimeException("n is more than length of the array");
        reverse(a, 0, a.length-1);
        reverse(a, 0, a.length-1-n);
        reverse(a, a.length-n, a.length-1);
    }
}
