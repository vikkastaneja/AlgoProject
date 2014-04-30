package org.vikastaneja.examples;

import com.google.common.base.Preconditions;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by vikastaneja on 2/21/14.
 */
public class MiscPrograms {
    /**
     * Helper function for {@link org.vikastaneja.examples.MiscPrograms#printDuplicates(byte[], byte[])}
     * @param b
     * @return
     */
    private static int getPosition(byte b) {
        return 127 + (int)b;
    }

    /**
     * Print duplicates from two arrays of 8-bit integers
     * @param b1
     * @param b2
     */
    public static void printDuplicates(byte []b1, byte[]b2) {
        if (b1 == null || b2 == null) {
            throw new RuntimeException("Either of the arrays is null");
        }

        if (b1.length == 0 || b2.length == 0) {
            System.out.println("No duplicates found");
            return;
        }

        boolean []ba = new boolean[255];
        for (int i = 0; i < 255; i++) {
            ba[i] = false;
        }

        for (byte b: b1) {
            ba[getPosition(b)] = true;
        }

        List<Byte> l = new ArrayList<Byte>();

        for (byte b : b2) {
            if (ba [getPosition(b)] && !l.contains(b)) {
                l.add(b);
            }
        }

        if (l.size() == 0) {
            System.out.println("No duplicates found");
            l = null;
            return;
        }

        for (byte b : l) {
            System.out.print(b + " ");
        }

        System.out.println();
    }

    private static int destFunction(int current, int jump, int length) {

        Preconditions.checkArgument(current >= 0 && jump > 0 && current < length && jump < length);
        return (current + jump + 1) % length;
    }

    public static void rotateArray(int []a, int jump) {
        int start_index = 0;
        int temp = start_index;
        int next;
        int local = a[temp];
        int length = a.length;
        while ((next = destFunction(temp, jump, length)) != start_index) {
            int t = a[next];
            a[next] = local;
            local = t;
            temp = next;
        }
    }

    public static void printPairsWithSum(int []arr, int sum) {
        if (arr == null) throw new RuntimeException();
        if (arr.length == 0) return;
        if (arr.length == 1 && arr[0] == sum) {
            System.out.println("The only element in the array is equal to sum");
            return;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (map.containsKey(sum - i)) {
                System.out.println("{" + i + "," + (sum - i) + "}");
            }

            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }
    }

    /**
     * Assumption: Both arrays are of same size
     * WAP to find the kth element from the two sorted array
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int findKth(Arr a, Arr b, int k) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkArgument(a.max >= a.min);
        Preconditions.checkArgument(b.max >= b.min);

        int lengthA = a.max - a.min;
        int lengthB = b.max - b.min;

        //Preconditions.checkArgument(k < lengthA + lengthB + 1);
        if (lengthA == 0 &&  lengthB == 0) {
            int small, big;
            if (a.array[a.min] < b.array[b.min]) {
                small = a.array[a.min];
                big = b.array[b.min];
            }
            else {
                big = a.array[a.min];
                small = b.array[b.min];
            }

            if (k == 0) return small;
            else return big;
        }

        if (k < (lengthA + lengthB)/2) {
            a.max -= lengthA / 2;
            b.max -= lengthB / 2;
        }
        else {
            a.min += lengthA/2 + 1;
            b.min += lengthB/2 + 1;
        }

        return findKth(a, b, k/2);
    }
}
