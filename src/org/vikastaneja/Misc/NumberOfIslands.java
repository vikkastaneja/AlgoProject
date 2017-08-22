import java.io.*;
import java.util.*;

class Solution {

// Logic is iterate through all the elements. As soon as '1' is hit, make the island to '0'
// For making island to '0', we use a queue of int[2] where each element in int[] correspond to current matrix element index.
  static int getNumberOfIslands(int[][] a) {
    if (a.length == 0 || a[0].length == 0) {
      return 0;
    }
    
    int counter = 0;
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[0].length; j++)
        if (a[i][j] == 1) {
          counter++;
          markIsland(a, i, j);
        }
    
    return counter;
  }

  private static void markIsland(int[][] a, int i, int j) {
    Queue<int[]> q = new LinkedList<int[]>();
    int[] l = new int[2];
    l[0]= i;
    l[1]= j;
    q.add(l);
    
    while (!q.isEmpty()) {
      int[] t = q.remove();
      int r = t[0];
      int c = t[1];
      a[r][c] = 0;
      if (r > 0 && a[r-1][c] == 1) {
        int[] tl = new int[2];
        tl[0]=r-1;
        tl[1]= c;
        q.add(tl);
      }
      
      if (c > 0 && a[r][c-1] == 1) {
        int[] tl = new int[2];
        tl[0]=r;
        tl[1]=c-1;
        q.add(tl);
      }
      
      if (r < a.length - 1 && a[r + 1][c] == 1) {
        int[] tl = new int[2];
        tl[0]=r+1;
        tl[1]=c;
        q.add(tl);
      }
      
      if (c < a[0].length - 1 && a[r][c + 1] == 1) {
        int[] tl = new int[2];
        tl[0]=r;
        tl[1]=c + 1;
        q.add(tl);
      }
    }
  }
  public static void main(String[] args) {
  }

}
