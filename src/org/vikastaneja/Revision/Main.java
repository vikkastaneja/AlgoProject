package org.vikastaneja.Revision;

import java.util.List;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class Main {
    public static void main(String[]args) {
        int []server = {8, 16, 4};
        int []jobs = {9, 4};
        boolean b = BinFitAlgorithm.serverFit(server, jobs);

        int [][]a = {{0, 1, 0, 0, 3},
                {0, 3, 3, 0, 0},
                {0, 0, 0, 0, 2},
                {0, 0, 1, 0, 2},
                {0, 0, 0, 0, 0}};
        System.out.println("Number of connected components: " + ConnectedComponents.numOfIslands(a));
        List<String> list = ConnectedComponents.findConnectedComponents(a);
        System.out.println("Components are: ");
        for (String s: list) {
            System.out.print(s + " ");
        }

        System.out.println();
        String perm = "abc";
        System.out.println(String.format("Permutation of %s", perm));
        Permutation.print(perm);

        int numOfParenthesis = 2;
        System.out.println("Parenthesis problem for " + numOfParenthesis);
        CombinationsOfParenthesis.printParenthesis(numOfParenthesis);

        int []subset = {1,2,3,4,5};
        System.out.println("Subsets of array: ");
        Subset.printAllSubsets(subset);

        // Merge sort
        int []arr = {6, 9, 5, 1, 0, 8, 10, 2};
        MergeSort.sort(arr);

        System.out.println("Sorted array is:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        try {
            MergeSort.sort(null);
        } catch (NullPointerException ex) {
            if (ex.getMessage() != "Array is null")
                throw ex;
        }

        int []tarr = {};
        MergeSort.sort(tarr);

        int []tarr1 = {1};
        MergeSort.sort(tarr1);

        int []tarr2 = {3, 2};
        MergeSort.sort(tarr2);
        System.out.println("Sorted array is:");
        for (int i : tarr2) {
            System.out.print(i + " ");
        }

        System.out.println();

        int size = 1000000;
        int []vl = new int[size];
        for (int i = 0; i < size; i++)
            vl[i] = size  - i;

        MergeSort.sort(vl);

        System.out.println("Sorted array is:");
        for (int i : vl) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
