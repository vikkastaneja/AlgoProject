package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

/**
 * Created by vikastaneja on 3/29/14.
 */
public class IslandProblem {
    /**
     * To check if there is an island in a matrix of zeroes and ones<br/>
     * Note that it does not validate if current element is other than zero or one.
     * @param b
     * @param a
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    private static boolean checkIsland(boolean [][]b, int [][]a, int m, int n, int i, int j) {
        if (b[i][j]) return true;

        b[i][j] = true;

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        if (i >= 1 && a[i-1][j] == 1 && !b[i-1][j])
            b1 = checkIsland(b, a, m, n, i-1, j);

        if (j >= 1 && a[i][j-1] == 1 && !b[i][j-1])
            b2 = checkIsland(b, a, m, n, i, j-1);

        if (i+1 < m && a[i+1][j] == 1 && !b[i+1][j])
            b3 = checkIsland(b, a, m, n, i+1, j);

        if (j+1 < n && a[i][j+1] == 1 && !b[i][j+1])
            b4 = checkIsland(b, a, m, n, i, j+1);

        return b1 || b2 || b3 || b4;

    }

    public static boolean isIslandPresent(int [][]a, int m, int n) {
        Preconditions.checkNotNull(a);
        Preconditions.checkArgument(m > 0);
        Preconditions.checkArgument(n > 0);
        boolean[][]b = new boolean[m][n];
        for (int i = 0; i < m-1; i++)
            for (int j = 0; j < n-1; j++)
                if (a[i][j] == 1 && !b[i][j] && checkIsland(b, a, m, n, i, j))
                    return true;

        return false;

    }
}
