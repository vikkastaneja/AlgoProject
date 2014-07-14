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
}
