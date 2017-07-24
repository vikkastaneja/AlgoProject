package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/8/14.
 */
public class BinFitAlgorithm {
  /**
   * We want to fit n objects of different sizes into unlimited number of boxes each can have size 'k'
   * There is a first fit algorithm - we pick each iteratively, and fit into box. If the box does not have enough space, we create another box and fit the item into it
   * There is a possible another approach - we keep a data structure such as an int array where each one will keep current available capacity of the respective bin.
   * For each item, we will parse and find if there is a bin that can accomodate the current one. If none, then we will add another bin. This algorithm is still not optimal as it will still iteratively find out and fit into first one.
   * Another approach is an enahancement of this one, where we will parse the complete array and find out the max capacity where the current item can fit into.
   **/
  private static int binPackageAlgorithm(int[] jobsSize) {
  
  }
  
    private static int binFitAlgo(int[] server, int[]jobs, int start, int end) {
        if (server == null || jobs == null)
            throw new NullPointerException("Either jobs or server is null");

        if (start > end)
            return 1;

        for (int i = 0; i < end; i++) {
            if (jobs[start] <= server[i]) {
                server[i] -= jobs[start];
                return 1;
            }

            binFitAlgo(server, jobs, start + 1, end);

            server[i] += jobs[start];
        }

        return 0;
    }

    public static boolean serverFit(int []server, int []jobs) {
        if (server == null || jobs == null)
            throw new NullPointerException("Either jobs or server is null");

        int retVal = binFitAlgo(server, jobs, 0, server.length - 1);

        if (retVal == 1)
            return true;
        else
            return false;
    }
}
