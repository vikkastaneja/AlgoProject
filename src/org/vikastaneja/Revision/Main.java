package org.vikastaneja.Revision;

import java.util.List;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class Main {
    public static void main(String[]args) {
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
    }
}
