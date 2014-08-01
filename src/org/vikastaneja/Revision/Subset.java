package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class Subset {
    public static void printAllSubsets(int []a) {
        if (a == null)
            throw new NullPointerException("Argument is null");

        if (a.length == 0) {
            System.out.println("Empty array is passed");
            return;
        }
        boolean[]b = new boolean[a.length];
        print(a, b, 0, a.length-1);
    }

    private static void print(int[] a, boolean[] b, int low, int high) {
        // Ignoring null check
        if (low > high) {
            System.out.print("{ ");
            for (int i = 0; i < a.length; i++) {
                if (b[i])
                    System.out.print(a[i] + " ");
            }

            System.out.println("}");
            System.out.println("===============");
        } else {
            b[low] = true;
            print(a, b, low + 1, high);
            b[low] = false;
            print(a, b, low + 1, high);
        }
    }
}
