package org.vikastaneja.Misc;

/**
 * Created by vikastaneja on 1/4/15.
 */

public class MatrixProblems {
    /**
     * Design an algo to decide if the GO game is over. i.e.
     * Given a boolean matrix, write a code to find if an island of 1's is completely surrounded by 0's.
     * @param a
     * @return
     */
    public static boolean IsGoGameOver(int [][] a)
    {
        if (a == null)
        {
            throw new RuntimeException("a");
        }

        if (a.length == 0 || a[0].length == 0)
        {
            System.out.println("Array length is zero");
            return false;
        }

        // The boolean 2D array is initialized to false
        boolean [][]visited = new boolean[a.length][a[0].length];

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[0].length; j++)
            {
                if (a[i][j] == 1 && !visited[i][j])
                {
                    if (IdentifyIsland(a, i, j, visited))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Actual logic to find if the island is surrounded with 0
     * @param a
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private static boolean IdentifyIsland(int[][] a, int row, int col, boolean[][] visited)
    {
        // No checks will be performed since this is an private class.

        visited[row][col] = true;
        if (row == 0 || row == a.length - 1 || col == 0 || col == a[0].length - 1) {
            visited[row][col] = false;
            return false;
        }

        boolean up = true;
        boolean down = true;
        boolean left = true;
        boolean right  = true;
        if (a[row - 1][col] == 1 && !visited[row - 1][col]) up = IdentifyIsland (a, row - 1, col, visited);
        if (a[row][col + 1] == 1 && !visited[row][col+1]) right = IdentifyIsland (a, row, col + 1, visited);
        if (a[row + 1][col] == 1 && !visited[row + 1][col]) down = IdentifyIsland (a, row + 1, col, visited);
        if (a[row][col - 1] == 1 && !visited[row][col - 1]) left = IdentifyIsland (a, row, col - 1, visited);
        return up && right && down && left;
    }
}
