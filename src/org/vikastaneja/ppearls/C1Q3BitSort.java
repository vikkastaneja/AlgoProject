package org.vikastaneja.ppearls;

import java.util.BitSet;

/**
 * Created by vikastaneja on 1/5/16.
 */
public class C1Q3BitSort {
    private final BitSet b;
    private final int length;
    public C1Q3BitSort(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Value of n should be greater than zero");
        }

        b = new BitSet(n);
        this.length = n;
    }

    public void add(int n) {
        if (n < 1 || n > this.length)
            throw new IllegalArgumentException();

        b.set(n - 1);
    }

    public void printSorted() {
        for (int  i = 0; i < this.length;) {
            int n = b.nextSetBit(i);
            if (n == -1) break;
            System.out.print(n+1+", ");
            i = n + 1;
        }

        System.out.println();
    }
}
