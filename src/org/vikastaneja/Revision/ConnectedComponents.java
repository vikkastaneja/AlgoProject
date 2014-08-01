package org.vikastaneja.Revision;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class ConnectedComponents {
    //Find number of islands in a matrix

    public static int numOfIslands(int[][] a){
        if (a == null)
            throw new NullPointerException("Passed matrix is null");

        if (a.length == 0) {
            System.out.println("Length of the matrix is zero");
            return 0;
        }


        int m = a.length;
        int n = a[0].length;
        int count = 0;
        boolean[][] b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!b[i][j] && a[i][j] != 0) {
                    traverse(a, b, i, j, m, n);
                    count ++;
                }
            }
        }

        return count;
    }

    public static List<String> findConnectedComponents(int[][] a){
        if (a == null)
            throw new NullPointerException("Passed matrix is null");

        if (a.length == 0) {
            System.out.println("Length of the matrix is zero");
            return new LinkedList<String>();
        }

        List<String> list = new LinkedList<String>();

        int m = a.length;
        int n = a[0].length;
        int count = 0;
        boolean[][] b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!b[i][j] && a[i][j] != 0) {
                    StringBuilder s = new StringBuilder();
                    traverseAndFind(a, b, i, j, m, n, s);
                    count ++;
                    list.add(s.toString());
                }
            }
        }

        return list;
    }

    private static void traverse(int[][]a, boolean[][]b, int i, int j, int m, int n) {
        // skipping null check for a while

        if (b[i][j]) return;
        b[i][j] = true;

        if (i > 1 && a[i-1][j] != 0 && !b[i-1][j])
            traverse(a, b, i-1, j, m, n);

        if (j > 1 && a[i][j-1] != 0 && !b[i][j-1])
            traverse(a, b, i, j-1, m, n);

        if (i < m-1 && a[i+1][j] != 0 && !b[i+1][j])
            traverse(a, b, i+1, j, m, n);

        if (j < n-1 && a[i][j+1] != 0 && !b[i][j+1])
            traverse(a, b, i, j+1, m, n);
    }

    private static void traverseAndFind(int[][]a, boolean[][]b, int i, int j, int m, int n, StringBuilder s) {
        // skipping null check for a while

        if (b[i][j]) return;
        b[i][j] = true;
        s.append(a[i][j]);

        if (i > 1 && a[i-1][j] != 0 && !b[i-1][j])
            traverseAndFind(a, b, i-1, j, m, n, s);

        if (j > 1 && a[i][j-1] != 0 && !b[i][j-1])
            traverseAndFind(a, b, i, j-1, m, n, s);

        if (i < m-1 && a[i+1][j] != 0 && !b[i+1][j])
            traverseAndFind(a, b, i+1, j, m, n, s);

        if (j < n-1 && a[i][j+1] != 0 && !b[i][j+1])
            traverseAndFind(a, b, i, j+1, m, n, s);
    }
}
