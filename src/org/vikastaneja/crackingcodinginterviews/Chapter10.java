package org.vikastaneja.crackingcodinginterviews;

/**
 * Created by vikastaneja on 7/13/14.
 */
public class Chapter10 {
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
