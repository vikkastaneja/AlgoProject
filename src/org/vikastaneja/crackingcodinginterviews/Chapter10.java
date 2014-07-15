package org.vikastaneja.crackingcodinginterviews;

/**
 * Created by vikastaneja on 7/13/14.
 */
public class Chapter10 {

    /**
     * Find if a number is in the array where the array is in increasing order and is rotated<br/>
     * Logic is find the strictly ordered partition first. If the number is in the strictly ordered partition, we apply binary search in the partition<br/>
     * Else, set the left or right to mid + 1 or mid - 1 based on the values.
     * @param a - input array
     * @param n - number to be searched for
     * @return  true or false
     */
    public static boolean findNumberInRotatedArray(int []a, int n) {
        if (a == null) throw new NullPointerException("Array is null");

        int left = 0;
        int right = a.length - 1;
        int mid = 0;

        // find the rotated one
        while (left < right) {
            mid = (left + right) / 2;
            if (a[mid] == n) return true;

            if (a[left] <= a[mid - 1]) {
                if (n <= a[mid - 1] && n >= a[left]) {
                    return bsearch(a, left, mid - 1, n);
                } else {
                    left = mid + 1;
                    continue;
                }
            } else if (a[mid + 1] <= a[right]) {
                if (n <= a[right] && a[mid + 1] <= n) {
                    return bsearch(a, mid + 1, right, n);
                } else {
                    right = mid - 1;
                    continue;
                }
            }
        }

        if (left == right && a[left] == n) return true;

        return false;
    }

    /**
     * Helper binary search functionality for {@link org.vikastaneja.crackingcodinginterviews.Chapter10#findNumberInRotatedArray(int[], int)}
     * @param a
     * @param l
     * @param r
     * @param n
     * @return
     */
    private static boolean bsearch(int[] a, int l, int r, int n) {
        int left = l;
        int right = r;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == n) return true;
            if (n < a[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }

    /**
     * Given an MxN sorted matrix - rows are sorted and columns are sorted. Find the element in it.<br/>
     * Strategy is to first apply binary search on the last column and then apply the same on the row.
     * @param a
     * @param n
     * @return  true if the element is present, false if element is not present. Throws null pointer exception when array is null.
     */
    public static boolean findElementInArray(int [][]a, int n) {
        if (a == null)
            throw new NullPointerException("Array is null");

        if (a.length == 0) {
            return false;
        }

        if (n < a[0][0] || n > a[a.length - 1][a[0].length - 1])
            return false;

        int c = a[0].length - 1;
        int top = 0;
        int bottom = a.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (a[mid][c] == n)
                return true;

            if (a[mid][c] > n)
                bottom = mid - 1;
            else
                top = mid + 1;
        }

        int row = top;
        int left = 0;
        int right = a[0].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[row][mid] == n)
                return true;

            if (n < a[row][mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }
}
