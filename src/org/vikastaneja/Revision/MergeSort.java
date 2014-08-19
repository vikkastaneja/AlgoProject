package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/19/14.
 */
public class MergeSort {

    public static void sort(int []a) {
        if (a == null)
            throw new NullPointerException("Array is null");

        if (a.length <= 1)
            return;

        mergeSort(a, 0, (a.length - 1) / 2, a.length - 1);
    }

    private static void mergeSort(int []a, int s, int m, int e) {
        if (e == s)
            return;

        if (e == s + 1) {
            if (a[s] > a[e]) {
                int temp = a[e];
                a[e] = a[s];
                a[s] = temp;
            }

            return;
        }


        mergeSort(a, s, s + (m - s) / 2, m);
        mergeSort(a, m + 1, (m + 1) + (e - m - 1) / 2, e);

        int []temp = new int[e - s + 1];
        int s1 = s;
        int m1 = m + 1;
        int i = 0;
        while ( m1 <= e && s1 <= m) {
            if (a[s1] < a[m1]) {
                temp[i++] = a[s1++];
            } else {
                temp[i++] = a[m1++];
            }
        }

        while (s1 <= m)
            temp[i++] = a[s1++];

        while (m1 <= e)
            temp[i++] = a[m1++];

        i = 0;
        int j = s;
        while (i < temp.length)
            a[j++] = temp[i++];

        return;
    }
}
