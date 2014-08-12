package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/8/14.
 */
public class BinFitAlgorithm {
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
