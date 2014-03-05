package org.vikastaneja.examples;

/**
 * Created by vikastaneja on 3/4/14.
 */
public class Recursive {

    public static void printSubsets(int []arr) {
        if (arr == null) {
            throw new RuntimeException("arr can't be null");
        }

        if (arr.length == 0) {
            System.out.println("Empty array has only empty subset");
            return;
        }

        boolean []b = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = false;
        }

        printSubsets(arr, b, 0, arr.length-1);
    }

    private static void printSubsets(int[]arr, boolean[]b, int start, int end) {
        if (arr == null) throw new RuntimeException("arr can't be null");
        if (b == null) throw new RuntimeException("boolean array can't be null");
        if (arr.length != b.length) throw new RuntimeException("lenght of two arrays can't be different");

        if (start > end) {
            printArray(arr, b);
        } else {
            b[start] = true;
            printSubsets(arr, b, start + 1, end);
            b[start] = false;
            printSubsets(arr, b, start + 1, end);
        }
    }

    private static void printArray(int []arr, boolean []b) {
        System.out.print("{");
        for(int i = 0; i < arr.length; i++)
            if(b[i])
                System.out.print(arr[i] + " ");
        System.out.print("}");
        System.out.println();
    }
}
