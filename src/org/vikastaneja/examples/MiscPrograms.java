package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

/**
 * Created by vikastaneja on 2/21/14.
 */
public class MiscPrograms {

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
