package org.vikastaneja.crackingcodinginterviews;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * In this file, I will solve all the problems of chapter1
 * Created by vikastaneja on 2/10/14.
 */
public class Chapter1 {

    /**
     * Helper method for {@link org.vikastaneja.crackingcodinginterviews.Chapter1#zeroRowsAndColumns(int[][])}<br/>
     * The method zeroes the row
     * @param a
     * @param r
     */
    private static void clearRow(int [][]a, int r) {
        if (a == null || a.length == 0)
            throw new NullPointerException("Passed array has some issues with its length");

        if (r < 0 || r >= a.length)
            throw new IllegalArgumentException("Passed row has invalid value");

        for (int i = 0; i < a[0].length; i++)
            a[r][i] = 0;
    }

    /**
     * Helper method for {@link org.vikastaneja.crackingcodinginterviews.Chapter1#zeroRowsAndColumns(int[][])}<br/>
     * The method zeroes the column
     * @param a
     * @param c
     */
    private static void clearColumn(int [][]a, int c) {
        if (a == null || a.length == 0)
            throw new NullPointerException("Passed array has some issues with its length");

        if (c < 0 || c >= a.length)
            throw new IllegalArgumentException("Passed column has invalid value");

        for (int i = 0; i < a.length; i++)
            a[i][c] = 0;
    }

    /**
     * Objective is to clear the row and columns for all the elements that are zero<br/>
     * It can be achieved using two boolean arrays, one for rows and another for column.<br/>
     * In the first parse, we will set all the entries in the rows and column array if the element is zero<br/>
     * In the second parse, parse the rows and columns arrays. If the entry is true, that row/column is zeroed in original array.
     * @param a Array which needs to be zeroed out.
     */
    public static void zeroRowsAndColumns(int[][]a) {
        if (a == null || a[0].length == 0) {
            throw new NullPointerException("Passed array is either null or of zero length");
        }

        boolean []rows = new boolean[a.length];
        boolean []columns = new boolean[a[0].length];
        for (int r = 0; r < rows.length; r++) {
            rows[r] = false;
        }

        for (int c = 0; c < columns.length; c++) {
            columns[c] = false;
        }

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] == 0) {
                    if (!rows[i]) rows[i] = !rows[i];
                    if (!columns[j]) columns[j] = !columns[j];
                }

        for (int r = 0; r < rows.length; r++)
            if (rows[r]) clearRow(a, r);

        for (int c = 0; c < columns.length; c++)
            if (columns[c]) clearColumn(a, c);
    }

    /**
     * Question: To find if duplicate characters are present in a string.<br/>
     * Solution implementing: Assuming the range is small, keep an array of booleans of 256 characters initialized to false<br/>
     * Parse the string. If the index is set to false, set it to true. If it is set to true, return false.
     * @param str   String to be looked into.
     * @return true if the string has not duplicates. false otherwise.
     */
    public static final Boolean isDuplicatePresent(final String str) {
        Preconditions.checkArgument(str != null);
        if (str.length() <= 1) {
            return true;
        }

        Boolean []arr = new Boolean[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (arr[value] == false) {
                arr[value] = true;
            }
            else {
                return false;
            }
        }

        return true;
    }

    /**
     * Problem: Given two string, find if one is permutation of other.
     * Solution: Out of different solution, I have selected to implement it using hashmap.
     * @param s1    First string
     * @param s2    Second string
     * @return  true if string are anagram, false otherwise
     */
    public static final Boolean isAnagram(final String s1, final String s2) {
        Preconditions.checkNotNull(s1);
        Preconditions.checkNotNull(s2);
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length != s2Length) {
            return false;
        }

        if (s1Length == 0 && s2Length == 0) {
            return true;
        }

        if ((s1Length == 0 && s2Length != 0) || (s2Length == 0 && s1Length != 0)) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1Length; i++) {
            Character ch = s1.charAt(i);
            if (map.containsKey(ch)) {
                Integer val = map.get(ch);
                val++;
                map.put(ch, val);
            }
            else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < s2Length; i++) {
            Character ch = s2.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            }

            Integer val = map.get(ch);
            val--;
            if (val < 0) {
                return false;
            }

            map.put(ch, val);
        }

        return true;

    }

    /**
     * Problem: Given a string, replace the spaces with %20
     * Approach: Count number of spaces. Start from the end+2*numSpaces and copy the characters from the end of the string.
     *           When space is hit, replace it with %20.
     * @param chStr
     */
    public static void updateString(char[] chStr) {
        Preconditions.checkNotNull(chStr) ;
        if (chStr.length == 0) {
            return;
        }

        //count number of spaces
        Integer numSpaces = 0;

        int n = 0;
        for (char ch : chStr) {
            if (ch == '\0') break;
            numSpaces = ch == ' ' ? numSpaces + 1 : numSpaces;
            n++;
        }

        if (numSpaces == 0) {
            return;
        }

        n--;
        int m = n + 2 * numSpaces;
        while ( m > n && n > 0) {
            if (chStr[n] == ' ') {
                chStr[m--] = '0';
                chStr[m--] = '2';
                chStr[m--] = '%';
                n--;
                continue;
            }

            chStr[m--] = chStr[n--];
        }

        return;
    }
}
