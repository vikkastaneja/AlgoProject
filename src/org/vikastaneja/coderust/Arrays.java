package org.vikastaneja.coderust;

/**
 * Created by vikastaneja on 3/31/14.
 */
public class Arrays {

    /**
     * Count number of elements in a sorted array
     * Approaches we discussed:
     * 1. Having a hashtable - O(length of the array)
     * 2. Having binary search and then linear for the both sides
     * 3. Having binary search to find out high and low indices.
     * Implemented #3 below.
     * @param sorted
     * @param number
     * @return
     */
    public static int count(int[] sorted, int number) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        if (sorted.length == 0)
            return -1;

        int low = lowIndex(sorted, number);

        int high = highIndex(sorted, number);

        // In any case, either both high and low are -1 or both are between 0 and sorted.length - 1
        return (high >=0 && low >= 0) ? high - (low - 1) : 0;

    }

    /**
     * Helper class for {@link org.vikastaneja.coderust.Arrays#count(int[], int)} for find the leftmost index
     * @param sorted
     * @param n
     * @return
     */
    private static int lowIndex(int[] sorted, int n) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        int low = 0;
        int high = sorted.length - 1;
        int mid = high/2;

        while (low <= high) {
            int m = sorted[mid];

            if (m < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (sorted[low] == n) return low;
        return -1;

    }

    /**
     * Helper class for {@link org.vikastaneja.coderust.Arrays#count(int[], int)} for find the rightmost index
     * @param sorted
     * @param n
     * @return
     */
    private static int highIndex(int[] sorted, int n) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        int low = 0;
        int high = sorted.length - 1;
        int mid = high/2;

        while (low <= high) {
            int m = sorted[mid];

            if (m <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (sorted[high] == n) return high;
        return -1;
    }

    /**
     * Find the kth number in the two sorted arrays when they are merged. <br/>
     * Few solutions:<br/>
     * 1. Merge the arrays and find the kth number<br/>
     * 2. Keep two pointers and find the kth number by traversing the arrays<br/>
     * 3. Optimization of 2, the solution can be divided into finding kth from the beginning or (m + n - k) from the last<br/>
     * 4. Get two integers pointing to indices of the two arrays such that their sum = k - i = k/2 and j = k/2 + k % 2 <br/>
     *      set step = k/2 <br/>
     *      if a[i] falls between b[j] and b[j+1] then a[i] is the kth integer (because i+j = k)<br/>
     *      if b[j] falls between a[i] and a[i+1] then b[j] is the kth integer<br/>
     *      else step = k / 2 and if a[i] < b[j] then increment i and decrement j by step (because now we want to consider b[j] to a[i] array)<br/>
     *      else step = k / 2 and if a[i] > b[j] then increment j and decrement j by step (because now we want to consider b[j] to a[i] array)
     * @param a - array 1 of size m
     * @param b - array 2 of size n
     * @param k - kth element to find
     * @return - kth element in the array
     */
    public static int returnKthInSortedArrays(int []a, int[]b, int k) {
        if (a == null || b == null)
            throw new NullPointerException("Either of the arrays are null");

        if (k <= 0 || k >= a.length + b.length)
            throw new IllegalArgumentException("Kth element does not exist in the arrays");

        if (a.length == 0 && b.length == 0)
            throw new IllegalArgumentException("Array lengths are zero");

        if (a.length == 0 && b.length > 0)
            return b[k - 1];

        if (b.length == 0 && a.length > 0)
            return a[k - 1];
        int r = k % 2;
        int  i = k/2-1;
        int j =  k/2-1 + r;
        int step = k / 2;
        while (step > 0) {
            if (a[i] > b[j] && b[j + 1] > a[i]) return a[i];
            else if (b[j] > a[i] && b[j] < a[i + 1]) return b[j];
            else if (a[i] > b[j] && a[i] > b[j + 1]){
                step /= 2;
                i -= step;
                j += step;
            } else {
                step /= 2;
                i += step;
                j -= step;
            }
        }

        return Integer.MIN_VALUE;
    }
}
